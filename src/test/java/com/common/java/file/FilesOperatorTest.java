package com.common.java.file;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

/**
 * <b><code>FilesOperatorTest</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 15:50
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Slf4j
public class FilesOperatorTest {

    @Test
    public void mkdirs(){
        Boolean result = FilesOperator.mkdirs("C:\\Users\\young\\Desktop\\");
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
            String result = FilesOperator.readStringUseNio(filePath, FilesOperator.CHARSET_NAME);
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
            List<String> result = FilesOperator.readAllLinesUseReader(filePath, FilesOperator.CHARSET_NAME);
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
            FilesOperator.readAllLinesUseReader(filePath, FilesOperator.CHARSET_NAME, (line) -> {});
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
            List<String> result = FilesOperator.readAllLinesUseNioReader(filePath, FilesOperator.CHARSET_NAME);
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
            FilesOperator.readAllLinesUseNioReader(filePath, FilesOperator.CHARSET_NAME, (line) -> {});
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
            List<String> result = FilesOperator.readAllLinesUseNioStream(filePath, FilesOperator.CHARSET_NAME);
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
            FilesOperator.readAllLinesUseNioStream(filePath, FilesOperator.CHARSET_NAME, (line) -> {});
            endTime = System.currentTimeMillis();
            log.info("{}ms-{}", endTime-startTime, filePath);
        }
    }

    @Test
    public void writeAllLinesUseNio(){
        FilesOperator.writeAllLinesUseNio(
                "C:\\Users\\young\\Desktop\\writeAllLinesUseNio.txt",
                "Hello World!",
                FilesOperator.CHARSET_NAME,
                StandardOpenOption.CREATE);
    }

    @Test
    public void writeAllLinesUseWriter(){
        FilesOperator.writeAllLinesUseWriter(
                "C:\\Users\\young\\Desktop\\writeAllLinesUseWriter.txt",
                Collections.singletonList("Hello World!"),
                FilesOperator.CHARSET_NAME,
                false);
    }

    @Test
    public void writeAllLinesUseNioWriter(){
        FilesOperator.writeAllLinesUseNioWriter(
                "C:\\Users\\young\\Desktop\\readAllLinesUseNioWriter.txt",
                Collections.singletonList("Hello World!"),
                FilesOperator.CHARSET_NAME,
                StandardOpenOption.CREATE);
    }

    @Test
    public void copyUseNio(){
        FilesOperator.copyUseNio(
                "D:\\documents\\notes\\solid\\摄影.MD",
                "C:\\Users\\young\\Desktop\\摄影.MD",
                StandardCopyOption.REPLACE_EXISTING);
        FilesOperator.copyUseNio(
                "D:\\Pictures\\JPG\\Processed\\DSC06413.JPG",
                "C:\\Users\\young\\Desktop\\DSC06413.JPG",
                StandardCopyOption.REPLACE_EXISTING);
    }

}
