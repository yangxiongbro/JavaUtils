package com.common.java.file;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * <b><code>FilesOperator</code></b>
 * <p/>
 * 文件工具类
 * <p/>
 * <b>Creation Time:</b> 2024/2/26 23:13
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Slf4j
public class FilesOperator {

    public static final String CHARSET_NAME = "UTF-8";

    /**
     * @description: 根据绝对路径创建目录
     * @param: filePath - 绝对路径
     * @return: boolean
     * @throws
     * @author yang xiong
     * @date 2024/4/21 18:34
     **/
    public static boolean mkdir(String filePath){
        File file = new File(filePath);
        if(!file.exists()){
            return file.mkdir();
        }
        return true;
    }

    /**
     * @description: 根据绝对路径创建多层目录
     * @param: filePath - 绝对路径
     * @return: boolean
     * @throws
     * @author yang xiong
     * @date 2024/4/21 18:34
     **/
    public static boolean mkdirs(String filePath){
        File file = new File(filePath);
        if(!file.exists()){
            return file.mkdirs();
        }
        return true;
    }

    /**
     * @description: NIO方式，整个文本文件读取到字符串，适用于小文件(文件不能超过2G)
     * @param: filePath - [String]
     * @param: charsetName - [String]
     * @return: java.util.List<java.lang.String>
     * @throws
     * @author yang xiong
     * @date 2024/4/21 15:49
     * @since  JDK 11
     **/
    public static String readStringUseNio(String filePath, String charsetName) {
        String content = null;
        try {
            content = Files.readString(Paths.get(filePath), Charset.forName(charsetName));
        } catch (Exception e) {
            log.error("FilesUtils#readStringUseNio:{}",e);
        }
        return content;
    }

    /**
     * @description: 经典的管道流方式，读取文本文件到 List
     * @param: filePath - 文件名
     * @param: charsetName - 字符编码名称
     * @return: java.util.List<java.lang.String>
     * @throws
     * @author yang xiong
     * @date 2024/4/21 15:30
     **/
    public static List<String> readAllLinesUseReader(String filePath, String charsetName) {
        List<String> content = new ArrayList<>();
        readAllLinesUseReader(filePath, charsetName, (line) -> content.add(line));
        return content;
    }

    /**
     * @description: 经典的管道流方式，读取文本文件，每读取到一行调用回调函数
     * @param: filePath - 文件名
     * @param: charsetName - 字符编码名称
     * @param: consumer - 每读取到一行调用的回调函数
     * @return: void
     * @throws
     * @author yang xiong
     * @date 2024/4/21 15:32
     **/
    public static void readAllLinesUseReader(String filePath, String charsetName, Consumer<String> consumer) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charsetName))) {
            String line;
            while ((line = br.readLine()) != null) {
                consumer.accept(line);
            }
        } catch (Exception e) {
            log.error("FilesUtils#readAllLinesUseReader:{}",e);
        }
    }

    /**
     * @description: NIO Stream方式，读取文本文件到 List
     * @param: filePath - 文件名
     * @param: charsetName - 字符编码名称
     * @return: java.util.List<java.lang.String>
     * @throws
     * @author yang xiong
     * @date 2024/4/21 15:30
     * @since  JDK 8
     **/
    public static List<String> readAllLinesUseNioReader(String filePath, String charsetName) {
        List<String> content = new ArrayList<>();
        readAllLinesUseNioReader(filePath, charsetName, (line) -> content.add(line));
        return content;
    }

    /**
     * @description: NIO Stream方式，读取文本文件，每读取到一行调用回调函数
     * @param: filePath - 文件名
     * @param: charsetName - 字符编码名称
     * @param: consumer - 每读取到一行调用的回调函数
     * @return: void
     * @throws
     * @author yang xiong
     * @date 2024/4/21 15:43
     * @since  JDK 8
     **/
    public static void readAllLinesUseNioReader(String filePath, String charsetName, Consumer<String> consumer) {
        // Files.readAllLines 与此类似
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath), Charset.forName(charsetName))) {
            String line;
            while ((line = br.readLine()) != null) {
                consumer.accept(line);
            }
        } catch (Exception e) {
            log.error("FilesUtils#readAllLinesUseNioReader:{}",e);
        }
    }

    /**
     * @description: NIO流方式，随机行顺序，读取文本文件到 List
     * @param: filePath - 文件名
     * @param: charsetName - 字符编码名称
     * @return: java.util.List<java.lang.String>
     * @throws
     * @author yang xiong
     * @date 2024/4/21 15:30
     * @since  JDK 8
     **/
    public static List<String> readAllLinesUseNioStream(String filePath, String charsetName) {
        List<String> content = new ArrayList<>();
        readAllLinesUseNioStream(filePath, charsetName, (line) -> content.add(line));
        return content;
    }

    /**
     * @description: NIO流方式，随机行顺序读取文本文件，每读取到一行调用回调函数
     * @param: filePath - 文件名
     * @param: charsetName - 字符编码名称
     * @param: consumer - 每读取到一行调用的回调函数
     * @return: void
     * @throws
     * @author yang xiong
     * @date 2024/4/21 15:43
     * @since  JDK 8
     **/
    public static void readAllLinesUseNioStream(String filePath, String charsetName, Consumer<String> consumer) {
        try {
            // 读取文件内容到Stream流中，按行读取
            Stream<String> stream = Files.lines(Paths.get(filePath), Charset.forName(charsetName));
            // 随机行顺序进行数据处理
            stream.forEach(line -> consumer.accept(line));
        } catch (Exception e) {
            log.error("FilesUtils#readAllLinesUseNioStream:{}",e);
        }
    }

    /**
     * @description: NIO方式，写入文本文件
     * @param: filePath - 文件名
     * @param: content - 写入文件的内容
     * @param: charsetName - 字符编码名称
     * @param: option - 打开方式
     * @return: void
     * @throws
     * @author yang xiong
     * @date 2024/4/21 15:49
     * @since  JDK 11
     **/
    public static void writeAllLinesUseNio(String filePath, String content, String charsetName, OpenOption option) {
        try {
            Files.writeString(Paths.get(filePath), content, Charset.forName(charsetName), option);
        } catch (IOException e) {
            log.error("FilesUtils#writeAllLinesUseNio:{}",e);
        }
    }

    /**
     * @description: 经典的管道流方式，写入文本文件
     * @param: filePath - 文件名
     * @param: content - 写入文件的内容
     * @param: charsetName - 字符编码名称
     * @param: append - 写入文件的内容
     * @return: void
     * @throws
     * @author yang xiong
     * @date 2024/4/21 15:32
     **/
    public static void writeAllLinesUseWriter(String filePath, List<String> content, String charsetName, Boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, Optional.ofNullable(append).orElse(false)), charsetName))) {
            for(String line:content){
                bw.write(line);
            }
        } catch (Exception e) {
            log.error("FilesUtils#writeAllLinesUseWriter:{}",e);
        }
    }

    /**
     * @description: NIO Stream方式，写入文本文件
     * @param: filePath - 文件名
     * @param: content - 写入文件的内容
     * @param: charsetName - 字符编码名称
     * @param: option - 打开方式
     * @return: void
     * @throws
     * @author yang xiong
     * @date 2024/4/21 15:43
     * @since  JDK 8
     **/
    public static void writeAllLinesUseNioWriter(String filePath, List<String> content, String charsetName, OpenOption option) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath), Charset.forName(charsetName), option)) {
            for(String line:content){
                bw.write(line);
            }
        } catch (Exception e) {
            log.error("FilesUtils#readAllLinesUseNioWriter:{}",e);
        }
    }

    /**
     * @description: 复制文件
     * @param: source - [String]
     * @param: target - [String]
     * @param: option - [CopyOption]
     * @return: void
     * @throws
     * @author yang xiong
     * @date 2024/4/21 18:05
     **/
    public static void copyUseNio(String source, String target, CopyOption option){
        try {
            Path path = Files.copy(Paths.get(source), Paths.get(target), option);
        } catch (Exception e) {
            log.error("FilesUtils#copyUseNio:{}",e);
        }
    }
}
