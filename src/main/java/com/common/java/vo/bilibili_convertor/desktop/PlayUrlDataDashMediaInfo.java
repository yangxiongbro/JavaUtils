package com.common.java.vo.bilibili_convertor.desktop;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * <b><code>PlayUrlDataDashMediaInfo</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 2:39
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Data
public class PlayUrlDataDashMediaInfo {

    @JsonAlias("id")
    private Integer id;      // 116,

    @JsonAlias({"baseUrl", "base_url"})
    private String baseUrl;     // "https://cn-jlcc-cu-03-02.bilivideo.com/upgcxcode/57/27/1437052757/1437052757-1-30116.m4s?e=ig8euxZM2rNcNbdlhoNvNC8BqJIzNbfqXBvEqxTEto8BTrNvN0GvT90W5JZMkX_YN0MvXg8gNEV4NC8xNEV4N03eN0B5tZlqNxTEto8BTrNvNeZVuJ10Kj_g2UB02J0mN0B5tZlqNCNEto8BTrNvNC7MTX502C8f2jmMQJ6mqF2fka1mqx6gqj0eN0B599M=&uipk=5&nbs=1&deadline=1713630344&gen=playurlv2&os=bcache&oi=3704016485&trid=0000d047c13d133f407db7dea8659f4a6347u&mid=394081610&platform=pc&upsig=e0a76b27c36a9182b55925189c59d6c7&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform&cdnid=3271&bvc=vod&nettype=0&orderid=0,3&buvid=9F1DC9B9D11E54D6ECA8422022082618UEEoHHTzaaLkqIivTRrJgg&build=0&f=u_0_0&agrr=0&bw=326192&logo=80000000",

    @JsonAlias("bandwidth")
    private Integer bandWidth;       // 2602336,

    @JsonAlias({"mimeType", "mime_type"})
    private String mimeType;        // "video/mp4",

    @JsonAlias("codecs")
    private String codecs;      // "avc1.640033",

    @JsonAlias("width")
    private Integer width;       // 1920,

    @JsonAlias("height")
    private Integer height;      // 1080,

    @JsonAlias({"frameRate", "frame_rate"})
    private String frameRate;       // "62.500",

    @JsonAlias("sar")
    private String sar;     // "1:1",

    @JsonAlias("startWithSap")
    private Integer startWithSap;        // 1,

    @JsonAlias("start_with_sap")
    private Integer start_with_sap;      // 1,

    @JsonAlias({"SegmentBase", "segment_base"})
    private PlayUrlDataDashMediaSegmentBaseInfo segmentBase;     // {},

    @JsonAlias("codecid")
    private Integer codecId;     // 7
}
