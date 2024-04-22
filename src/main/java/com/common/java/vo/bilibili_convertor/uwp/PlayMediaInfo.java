package com.common.java.vo.bilibili_convertor.uwp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * <b><code>PlayAudioInfo</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 1:29
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayMediaInfo {

    @JsonProperty("MediaType")
    private Integer mediaType;     // 1,

    @JsonProperty("CodecId")
    private Integer codecId;       // .playurl.data.dash.audio.codecid 0,

    @JsonProperty("CodecName")
    private String codecName;     // .playurl.data.dash.audio.codecs "mp4a.40.2",

    @JsonProperty("VideoWidth")
    private Integer videoWidth;    // .playurl.data.dash.audio.width 0,

    @JsonProperty("VideoHeight")
    private Integer videoHeight;   // .playurl.data.dash.audio.height 0,

    @JsonProperty("Bandwidth")
    private Integer bandWidth;     // .playurl.data.dash.audio.bandwidth 108639,

    @JsonProperty("FrameRate")
    private BigDecimal frameRate;      // .playurl.data.dash.audio.frame_rate 0.0

    public static PlayMediaInfo getDefaultAudioInfo(){
        return new PlayMediaInfo(
                1,
                0,
                "mp4a.40.2",
                0,
                0,
                0,
                new BigDecimal("0.0")
        );
    }

    public static PlayMediaInfo getDefaultVideoInfo(){
        return new PlayMediaInfo(
                0,
                12,
                "hev1.1.6.L150.90",
                1920,
                1080,
                0,
                new BigDecimal("30.303")
        );
    }
}
