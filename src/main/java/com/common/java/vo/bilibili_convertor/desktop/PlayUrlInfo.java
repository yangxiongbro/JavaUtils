package com.common.java.vo.bilibili_convertor.desktop;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * <b><code>PlayurlInfo</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 2:13
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Data
public class PlayUrlInfo {

    @JsonAlias("code")
    private Integer code;        // 0

    @JsonAlias("message")
    private String message;     // "0"

    @JsonAlias("ttl")
    private Integer ttl;         // 1

    @JsonAlias("data")
    private PlayUrlDataInfo data;
}
