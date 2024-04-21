package com.common.java.vo.bilibili_convertor.uwp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b><code>DviInfo</code></b>
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
public class DviInfo {

    @JsonProperty("Aid")
    private String aid;         // videoinfo.aid "793956608"

    @JsonProperty("Bid")
    private String bid;         // videoinfo.bvid "BV1xC4y1C7GL"

    @JsonProperty("SeasonId")
    private String seasonId;    // null

    @JsonProperty("EpisodeId")
    private String episodeId;   // null

    @JsonProperty("Title")
    private String title;       // videoinfo.title "做事情要考虑周全"

    @JsonProperty("Uploader")
    private String uploader;    // videoinfo.uname "武主任-企业综合办"

    @JsonProperty("Mid")
    private String mid;         // videoinfo.uid "3537111693134660"

    @JsonProperty("Description")
    private String description; // null

    @JsonProperty("CoverURL")
    private String coverURL;    // videoinfo.coverUrl "http://i1.hdslb.com/bfs/archive/8a559bcf10b342563ff863fec52d5e16952ef28f.jpg"

    @JsonProperty("Tag")
    private String tag;         // null

    @JsonProperty("DownloadTimeRelative")
    private Long downloadTimeRelative;  // 下载列表顺序，发布日期 - 2014-10-01 00:00:00

    @JsonProperty("CreateDate")
    private String createDate;  // moment(new Date(videoInfo.pubdate*1000)).format("yyyy-MM-DD HH:mm") "2024-01-17 08:16"

    @JsonProperty("IsBangumi")
    private Boolean isBangumi;  // false

    @JsonProperty("Is360")
    private Boolean is360;      // false

    @JsonProperty("TotalTime")
    private String totalTime;   // "00:00:00"

    @JsonProperty("Parts")
    private Integer parts;        // null
}
