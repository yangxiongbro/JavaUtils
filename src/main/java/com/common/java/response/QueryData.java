package com.common.java.response;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.ArrayList;
import java.util.List;

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

    QueryData(IPage page){
        this.totalCount = page.getTotal();
        this.pages = page.getPages();
        this.pageNo = page.getCurrent();
        this.pageSize = page.getSize();
        List<?> oldRecordList = page.getRecords();
        this.records = new ArrayList<>(oldRecordList.size());
        for(Object item : oldRecordList){
            
        }
    }


}
