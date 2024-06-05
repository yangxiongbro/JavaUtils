package com.common.java.vo.bilibili_convertor.uwp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <b><code>PlayInfo</code></b>
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
public class PlayInfo {

    @JsonProperty("Type")
    private Integer type;              // 0

    @JsonProperty("Aid")
    private String aid;               // videoinfo.aid "873942182"

    @JsonProperty("Bid")
    private String bid;               // videoinfo.bvid "BV1cK4y1c7YD"

    @JsonProperty("Cid")
    private String cid;               // videoinfo.cid "1280929245"

    @JsonProperty("SeasonId")
    private String seasonId;          // null

    @JsonProperty("EpisodeId")
    private String episodeId;         // null

    @JsonProperty("Title")
    private String title;             // videoinfo.groupTitle "回家的路，永远为你照亮前方"

    @JsonProperty("Uploader")
    private String uploader;          // videoinfo.uname "不自由寻迹"

    @JsonProperty("Description")
    private String description;       // null

    @JsonProperty("CoverURL")
    private String coverURL;          // videoinfo.coverUrl "http://i2.hdslb.com/bfs/archive/267366a2ccf80abd0496ba26f4cfca41794d7778.jpg"

    @JsonProperty("Tag")
    private String tag;               // null

    @JsonProperty("From")
    private String from;              // "vupload"

    @JsonProperty("PartNo")
    private String partNo;            // videoInfo.p

    @JsonProperty("PartName")
    private String partName;           // videoinfo.title "回家的路，永远为你照亮前方"

    @JsonProperty("Format")
    private Integer format;            // 2

    @JsonProperty("TotalParts")
    private Integer totalParts;        // 1

    @JsonProperty("DownloadTimeRelative")
    private Long downloadTimeRelative; // 下载列表顺序，发布日期 - 2014-10-01 00:00:00

    @JsonProperty("CreateDate")
    private String createDate;        // moment(new Date(videoInfo.pubdate*1000)).format("yyyy-MM-DD HH:mm") "2023-09-27 10:29"

    @JsonProperty("TotalTime")
    private String totalTime;         // DateTimeUtils.secondsToHMSMS(.playurl.data.timelength)+"0000" "00:00:21.0340000"

    @JsonProperty("PartTime")
    private List<Integer> partTime;       // .playurl.data.timelength

    @JsonProperty("TotalSizeByte")
    private Long totalSizeByte;     // videoInfo.totalSize 1449919

    @JsonProperty("TotalSizeString")
    private String totalSizeString;   // null

    @JsonProperty("IsSinglePart")
    private Boolean isSinglePart;     // true

    @JsonProperty("IsDash")
    private Boolean isDash;           // false

    @JsonProperty("IsMerged")
    private Boolean isMerged;         // true

    @JsonProperty("VideoInfo")
    private PlayMediaInfo videoInfo;

    @JsonProperty("AudioInfo")
    private List<PlayMediaInfo> audioInfo;
}
