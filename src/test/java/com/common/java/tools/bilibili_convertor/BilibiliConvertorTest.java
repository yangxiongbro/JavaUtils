package com.common.java.tools.bilibili_convertor;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;


/**
 * <b><code>BilibiliConvertorTest</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 1:49
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class BilibiliConvertorTest {

    @Test
    public void convert() throws JsonProcessingException {
        BilibiliConvertor convertor = new BilibiliConvertor();
        convertor.convert("D:\\video\\bilibili\\m4s", "C:\\Users\\young\\Desktop\\bilibili");
    }
}
