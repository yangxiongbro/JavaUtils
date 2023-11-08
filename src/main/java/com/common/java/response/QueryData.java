package com.common.java.response;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * <b><code>QueryDdata</code></b>
 * <p/>
 * 统一返回结果 QueryDdata
 * <p/>
 * <b>Creation Time:</b> 2023/11/2 0:10
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class QueryData<T> {
    /**
     * 总条数
     */
    private long totalCount;

    /**
     * 总页数
     */
    private long pages;

    /**
     * 当前页码
     */
    private long pageNo;

    /**
     * 当前页大小
     */
    private long pageSize;

    /**
     * 数据
     */
    private List<T> records;

    QueryData(){

    }

    QueryData(IPage<T> page){
        setPage(page);
        this.records = page.getRecords();
    }

    QueryData(PageInfo<T> page){
        setPage(page);
        this.records = page.getList();
    }

    <PT> QueryData(IPage<PT> page, Function<PT, T> convertFun){
        setPage(page);
        setRecords(page.getRecords(), convertFun);
    }

    <PT> QueryData(PageInfo<PT> page, Function<PT, T> convertFun){
        setPage(page);
        setRecords(page.getList(), convertFun);
    }

    private void setPage(IPage<?> page){
        this.totalCount = page.getTotal();
        this.pages = page.getPages();
        this.pageNo = page.getCurrent();
        this.pageSize = page.getSize();
    }

    private void setPage(PageInfo<?> page){
        this.totalCount = page.getTotal();
        this.pages = page.getPages();
        this.pageNo = page.getPageNum();
        this.pageSize = page.getPageSize();
    }

    private <PT> void setRecords(List<PT> oldRecordList, Function<PT, T> convertFun){
        this.records = new ArrayList<>(oldRecordList.size());
        for(PT item : oldRecordList){
            this.records.add(convertFun.apply(item));
        }
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
