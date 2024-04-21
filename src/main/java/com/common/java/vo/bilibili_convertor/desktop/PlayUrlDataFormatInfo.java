package com.common.java.vo.bilibili_convertor.desktop;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

/**
 * <b><code>PlayUrlDataFormatInfo</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 2:30
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Data
public class PlayUrlDataFormatInfo {

    @JsonAlias("quality")
    private Integer quality;    // 116

    @JsonAlias("format")
    private String format;      // "flv_p60"

    @JsonAlias("new_description")
    private String newDescription;  // "1080P 60帧"

    @JsonAlias("display_desc")
    private String displayDesc;     // "1080P"

    @JsonAlias("superscript")
    private String superscript;     // "60帧"

    @JsonAlias("codecs")
    private List<String> codecs;    // []
}
