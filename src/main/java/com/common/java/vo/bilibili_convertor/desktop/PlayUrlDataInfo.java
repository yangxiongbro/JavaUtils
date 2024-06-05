package com.common.java.vo.bilibili_convertor.desktop;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

/**
 * <b><code>PlayUrlDataInfo</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 2:22
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Data
public class PlayUrlDataInfo {

    @JsonAlias("from")
    private String from;            // "local",

    @JsonAlias("result")
    private String result;          // "suee",

    @JsonAlias("message")
    private String message;         // "",

    @JsonAlias("quality")
    private Integer quality;        // 116,

    @JsonAlias("format")
    private String format;          // "flv_p60",

    @JsonAlias("timelength")
    private Integer timeLength;     // 78390,

    @JsonAlias("accept_format")
    private String acceptFormat;    // "flv_p60,flv,flv720,flv480,flv360",

    @JsonAlias("accept_description")
    private List<String> acceptDescription;    // [],

    @JsonAlias("accept_quality")
    private List<Integer> acceptQuality;       // [],

    @JsonAlias("video_codecid")
    private Integer videoCodecId;    // 7,

    @JsonAlias("seek_param")
    private String seekParam;        // "start",

    @JsonAlias("seek_type")
    private String seekType;         // "offset",

    @JsonAlias("dash")
    private PlayUrlDataDashInfo dash;      // {},

    @JsonAlias("support_formats")
    private List<PlayUrlDataFormatInfo> supportFormats;   // [],

    @JsonAlias("high_format")
    private String highFormat;         // null,

    @JsonAlias("last_play_time")
    private Integer lastPlayTime;      // 0,

    @JsonAlias("last_play_cid")
    private Integer lastPlayCid;       // 0,

    @JsonAlias("view_info")
    private String viewInfo;           // null
}
