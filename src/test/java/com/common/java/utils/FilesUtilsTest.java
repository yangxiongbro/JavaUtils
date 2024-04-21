package com.common.java.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

/**
 * <b><code>FilesUtilsTest</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 15:50
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Slf4j
public class FilesUtilsTest {

    @Test
    public void mkdirs(){
        Boolean result = FilesUtils.mkdirs("C:\\Users\\young\\Desktop\\");
        log.info("{}", result);
    }

    @Test
    public void readStringUseNio(){
        String[] filePaths = new String[]{
                "D:\\documents\\notes\\solid\\摄影.MD",
                "D:\\documents\\notes\\solid\\葵花宝典.MD",
        };
        long startTime, endTime;
        for(String filePath:filePaths){
            startTime = System.currentTimeMillis();
            String result = FilesUtils.readStringUseNio(filePath, FilesUtils.CHARSET_NAME);
            endTime = System.currentTimeMillis();
            log.info("{}ms-{}", endTime-startTime, filePath);
        }
    }

    @Test
    public void readAllLinesUseReader(){
        String[] filePaths = new String[]{
                "D:\\documents\\notes\\solid\\摄影.MD",
                "D:\\documents\\notes\\solid\\葵花宝典.MD",
        };
        long startTime, endTime;
        for(String filePath:filePaths){
            startTime = System.currentTimeMillis();
            List<String> result = FilesUtils.readAllLinesUseReader(filePath, FilesUtils.CHARSET_NAME);
            endTime = System.currentTimeMillis();
            log.info("{}ms-{}", endTime-startTime, filePath);
        }
    }

    @Test
    public void readAllLinesUseReader2(){
        String[] filePaths = new String[]{
                "D:\\documents\\notes\\solid\\摄影.MD",
                "D:\\documents\\notes\\solid\\葵花宝典.MD",
        };
        long startTime, endTime;
        for(String filePath:filePaths){
            startTime = System.currentTimeMillis();
            FilesUtils.readAllLinesUseReader(filePath, FilesUtils.CHARSET_NAME, (line) -> {});
            endTime = System.currentTimeMillis();
            log.info("{}ms-{}", endTime-startTime, filePath);
        }
    }

    @Test
    public void readAllLinesUseNioReader(){
        String[] filePaths = new String[]{
                "D:\\documents\\notes\\solid\\摄影.MD",
                "D:\\documents\\notes\\solid\\葵花宝典.MD",
        };
        long startTime, endTime;
        for(String filePath:filePaths){
            startTime = System.currentTimeMillis();
            List<String> result = FilesUtils.readAllLinesUseNioReader(filePath, FilesUtils.CHARSET_NAME);
            endTime = System.currentTimeMillis();
            log.info("{}ms-{}", endTime-startTime, filePath);
        }
    }

    @Test
    public void readAllLinesUseNioReader2(){
        String[] filePaths = new String[]{
                "D:\\documents\\notes\\solid\\摄影.MD",
                "D:\\documents\\notes\\solid\\葵花宝典.MD",
        };
        long startTime, endTime;
        for(String filePath:filePaths){
            startTime = System.currentTimeMillis();
            FilesUtils.readAllLinesUseNioReader(filePath, FilesUtils.CHARSET_NAME, (line) -> {});
            endTime = System.currentTimeMillis();
            log.info("{}ms-{}", endTime-startTime, filePath);
        }
    }

    @Test
    public void readAllLinesUseNioStream(){
        String[] filePaths = new String[]{
                "D:\\documents\\notes\\solid\\摄影.MD",
                "D:\\documents\\notes\\solid\\葵花宝典.MD",
        };
        long startTime, endTime;
        for(String filePath:filePaths){
            startTime = System.currentTimeMillis();
            List<String> result = FilesUtils.readAllLinesUseNioStream(filePath, FilesUtils.CHARSET_NAME);
            endTime = System.currentTimeMillis();
            log.info("{}ms-{}", endTime-startTime, filePath);
        }
    }

    @Test
    public void readAllLinesUseNioStream2(){
        String[] filePaths = new String[]{
                "D:\\documents\\notes\\solid\\摄影.MD",
                "D:\\documents\\notes\\solid\\葵花宝典.MD",
        };
        long startTime, endTime;
        for(String filePath:filePaths){
            startTime = System.currentTimeMillis();
            FilesUtils.readAllLinesUseNioStream(filePath, FilesUtils.CHARSET_NAME, (line) -> {});
            endTime = System.currentTimeMillis();
            log.info("{}ms-{}", endTime-startTime, filePath);
        }
    }

    @Test
    public void writeAllLinesUseNio(){
        FilesUtils.writeAllLinesUseNio(
                "C:\\Users\\young\\Desktop\\writeAllLinesUseNio.txt",
                "Hello World!",
                FilesUtils.CHARSET_NAME,
                StandardOpenOption.CREATE);
    }

    @Test
    public void writeAllLinesUseWriter(){
        FilesUtils.writeAllLinesUseWriter(
                "C:\\Users\\young\\Desktop\\writeAllLinesUseWriter.txt",
                Collections.singletonList("Hello World!"),
                FilesUtils.CHARSET_NAME,
                false);
    }

    @Test
    public void writeAllLinesUseNioWriter(){
        FilesUtils.writeAllLinesUseNioWriter(
                "C:\\Users\\young\\Desktop\\readAllLinesUseNioWriter.txt",
                Collections.singletonList("Hello World!"),
                FilesUtils.CHARSET_NAME,
                StandardOpenOption.CREATE);
    }

    @Test
    public void copyUseNio(){
        FilesUtils.copyUseNio(
                "D:\\documents\\notes\\solid\\摄影.MD",
                "C:\\Users\\young\\Desktop\\摄影.MD",
                StandardCopyOption.REPLACE_EXISTING);
        FilesUtils.copyUseNio(
                "D:\\Pictures\\JPG\\Processed\\DSC06413.JPG",
                "C:\\Users\\young\\Desktop\\DSC06413.JPG",
                StandardCopyOption.REPLACE_EXISTING);
    }

}
