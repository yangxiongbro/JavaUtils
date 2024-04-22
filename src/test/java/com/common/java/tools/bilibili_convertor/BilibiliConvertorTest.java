package com.common.java.tools.bilibili_convertor;

import com.common.java.vo.bilibili_convertor.desktop.PlayUrlInfo;
import com.common.java.vo.bilibili_convertor.desktop.VideoInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        String source = "D:\\video\\bilibili\\m4s";
        String target = "C:\\Users\\young\\Desktop\\bilibili";
        BilibiliConvertor convertor = new BilibiliConvertor();
        Map<String, Map<String, File>> pathFileMap = convertor.packageFile(source);
        Map<String, List<VideoInfo>> videoInfoMap = new HashMap<>(pathFileMap.size());
        Map<String, Map<Long, PlayUrlInfo >> playUrlInfoMap = new HashMap<>(pathFileMap.size());
        Map<String, Map<Long, File>> coverFileMap = new HashMap<>(pathFileMap.size());
        convertor.parseInfo(pathFileMap, videoInfoMap, playUrlInfoMap, coverFileMap);
        convertor.convert(target, videoInfoMap, playUrlInfoMap, coverFileMap);
    }
}
