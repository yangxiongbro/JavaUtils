package com.common.java.vo.bilibili_convertor.desktop;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * <b><code>PlayUrlDataDashDolbyInfo</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 2:37
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Data
public class PlayUrlDataDashDolbyInfo {

    @JsonAlias("type")
    private Integer type;     // 0

    @JsonAlias("audio")
    private String audio;    // null
}
