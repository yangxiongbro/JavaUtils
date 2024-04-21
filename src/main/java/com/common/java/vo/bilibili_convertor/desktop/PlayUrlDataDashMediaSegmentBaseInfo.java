package com.common.java.vo.bilibili_convertor.desktop;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * <b><code>PlayUrlDataDashMediaSegmentBaseInfo</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 2:42
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Data
public class PlayUrlDataDashMediaSegmentBaseInfo {

    @JsonAlias({"Initialization", "initialization"})
    private String initialization;  // "0-1009",

    @JsonAlias({"indexRange", "index_range"})
    private String indexRange;      // "1010-1233"
}
