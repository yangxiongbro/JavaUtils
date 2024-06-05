package com.common.java.vo.bilibili_convertor.desktop;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * <b><code>VideoInfo</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 2:13
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Data
public class VideoInfo {

    @JsonAlias("type")
    private String type;            // "ugc",

    @JsonAlias("codecid")
    private Integer codecId;        // 7,

    @JsonAlias("groupId")
    private String groupId;         // "BV1km411D7rc",

    @JsonAlias("itemId")
    private Long itemId;         // 1437052757,

    @JsonAlias("aid")
    private Long aid;            // 1900706694,

    @JsonAlias("cid")
    private Long cid;            // 1437052757,

    @JsonAlias("bvid")
    private String bvId;            // "BV1km411D7rc",

    @JsonAlias("p")
    private Integer p;              // 1,

    @JsonAlias("tabP")
    private Integer tabP;           // 0,

    @JsonAlias("tabName")
    private String tabName;         // "上一个这么剪的已经1.2亿播放了",

    @JsonAlias("uid")
    private String uid;             // "1398957",

    @JsonAlias("uname")
    private String uname;           // "树深时见鹿dear",

    @JsonAlias("avatar")
    private String avatar;          // "https://i0.hdslb.com/bfs/face/3492081b9cf0a59626c663537fe30f0acf53f6c5.jpg",

    @JsonAlias("coverUrl")
    private String coverUrl;        // "http://i0.hdslb.com/bfs/archive/39c48528828ecd9b63463709378aaf26d8a32003.jpg",

    @JsonAlias("title")
    private String title;           // "上一个这么剪的已经1.2亿播放了",

    @JsonAlias("duration")
    private Integer duration;       // 79,

    @JsonAlias("groupTitle")
    private String groupTitle;      // "上一个这么剪的已经1.2亿播放了",

    @JsonAlias("groupCoverUrl")
    private String groupCoverUrl;   // "http://i0.hdslb.com/bfs/archive/39c48528828ecd9b63463709378aaf26d8a32003.jpg",

    @JsonAlias("danmaku")
    private Integer danmaku;        // 2782,

    @JsonAlias("view")
    private Integer view;           // 4643823,

    @JsonAlias("pubdate")
    private Long pubDate;          // 1707651625,

    @JsonAlias("vt")
    private Integer vt;             // 0,

    @JsonAlias("status")
    private String status;          // "completed",

    @JsonAlias("active")
    private Boolean active;         // true,

    @JsonAlias("loaded")
    private Boolean loaded;         // true,

    @JsonAlias("qn")
    private Integer qn;             // 116,

    @JsonAlias("allowHEVC")
    private Boolean allowHevc;      // false,

    @JsonAlias("createTime")
    private Long createTime;     // 1713622941550,

    @JsonAlias("coverPath")
    private String coverPath;       // "D:\\video\\bilibili\\m4s\\1437052757\\image.jpg",

    @JsonAlias("groupCoverPath")
    private String groupCoverPath;  // "D:\\video\\bilibili\\m4s\\1437052757\\group.jpg",

    @JsonAlias("updateTime")
    private Long updateTime;     // 1713623147671,

    @JsonAlias("totalSize")
    private Long totalSize;      // 27270664,

    @JsonAlias("loadedSize")
    private Long loadedSize;     // 27270664,

    @JsonAlias("progress")
    private Integer progress;       // 100,

    @JsonAlias("speed")
    private Integer speed;          // 0,

    @JsonAlias("completionTime")
    private Long completionTime; // 1713623147637,

    @JsonAlias("reportedSize")
    private Long reportedSize;   // 27270664
}
