package com.common.java.vo.bilibili_convertor.desktop;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

/**
 * <b><code>PlayUrlDataDashInfo</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 2:33
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Data
public class PlayUrlDataDashInfo {

    @JsonAlias("duration")
    private Integer duration;        // 79

    @JsonAlias({"minBufferTime", "min_buffer_time"})
    private Float minBufferTime;   // 1.5

    @JsonAlias("video")
    private List<PlayUrlDataDashMediaInfo> video;       // []

    @JsonAlias("audio")
    private List<PlayUrlDataDashMediaInfo> audio;       // []

    @JsonAlias("dolby")
    private PlayUrlDataDashDolbyInfo dolby;       // {}

    @JsonAlias("flac")
    private String flac;        // null
}
