package com.common.java.tools.bilibili_convertor;

import com.common.java.utils.DateTimeUtils;
import com.common.java.utils.FilesUtils;
import com.common.java.vo.bilibili_convertor.desktop.PlayUrlDataFormatInfo;
import com.common.java.vo.bilibili_convertor.desktop.PlayUrlInfo;
import com.common.java.vo.bilibili_convertor.desktop.VideoInfo;
import com.common.java.vo.bilibili_convertor.uwp.DviInfo;
import com.common.java.vo.bilibili_convertor.uwp.PlayInfo;
import com.common.java.vo.bilibili_convertor.uwp.PlayMediaInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <b><code>BilibiliConvertor</code></b>
 * <p/>
 * bilibili桌面版转UWP版
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 0:20
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class BilibiliConvertor {

    public void convert(String source, String target) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        FilesUtils.mkdirs(target);
        Map<String, Map<String, File>> pathFileMap = packageFile(source);
        for(Map.Entry<String, Map<String, File>> pathFileEntry: pathFileMap.entrySet()){
            System.out.println(pathFileEntry.getKey());
            Map<String, File> pathMap = pathFileEntry.getValue();
            File playUrlFile = pathMap.get(".playurl");
            File videoInfoFile = pathMap.get(".videoInfo");
            File coverFile = pathMap.get("image.jpg");
            if(null == playUrlFile || null == videoInfoFile || !playUrlFile.exists() || !videoInfoFile.exists()){
                continue;
            }
            PlayUrlInfo playUrlInfo = mapper.readValue(FilesUtils.readStringUseNio(playUrlFile.getPath(), FilesUtils.CHARSET_NAME), PlayUrlInfo.class);
            VideoInfo videoInfo = mapper.readValue(FilesUtils.readStringUseNio(videoInfoFile.getPath(), FilesUtils.CHARSET_NAME), VideoInfo.class);
            System.out.println(playUrlInfo);
            System.out.println(videoInfo);
            DviInfo dviInfo = getDviInfo(videoInfo);
            String desktopIniInfo = getDesktopIniInfo(videoInfo);
            String dmInfo = getDmInfo(videoInfo);
            PlayInfo playInfo = getPlayInfo(playUrlInfo, videoInfo);
            String aid = videoInfo.getAid().toString();

            String videoInfoDir = target + "\\" + aid;
            String playInfoDir = videoInfoDir + "\\1";
            FilesUtils.mkdir(videoInfoDir);
            FilesUtils.mkdir(playInfoDir);
            FilesUtils.writeAllLinesUseNio(videoInfoDir + "\\" + aid + ".dvi",
                    mapper.writeValueAsString(dviInfo), FilesUtils.CHARSET_NAME, StandardOpenOption.CREATE);
            FilesUtils.writeAllLinesUseNio(videoInfoDir + "\\desktop.ini",
                    desktopIniInfo, FilesUtils.CHARSET_NAME, StandardOpenOption.CREATE);
            FilesUtils.writeAllLinesUseNio(playInfoDir + "\\" + aid + "_1.xml",
                    dmInfo, FilesUtils.CHARSET_NAME, StandardOpenOption.CREATE);
            FilesUtils.writeAllLinesUseNio(playInfoDir + "\\" + aid + ".info",
                    mapper.writeValueAsString(playInfo), FilesUtils.CHARSET_NAME, StandardOpenOption.CREATE);
            FilesUtils.writeAllLinesUseNio(playInfoDir + "\\" + videoInfo.getTitle() + ".txt",
                    videoInfo.getTitle(), FilesUtils.CHARSET_NAME, StandardOpenOption.CREATE);
            if(null != coverFile && coverFile.exists()){
                FilesUtils.copyUseNio(coverFile.getPath(), videoInfoDir + "\\cover.jpg", StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    public Map<String, Map<String, File>> packageFile(String sourcePath){
        File[] pathFiles = new File(sourcePath).listFiles(file -> file.isDirectory());
        Map<String, Map<String, File>> pathFileMap = new HashMap<>(pathFiles.length);
        for(File path:pathFiles){
            String pathName = path.getName();
            File[] files = path.listFiles(file -> file.isFile());
            pathFileMap.put(pathName,
                    Arrays.stream(files).collect(Collectors.toMap(File::getName, Function.identity()))
            );
        }
        return pathFileMap;
    }

    public DviInfo getDviInfo(VideoInfo videoInfo){
        return new DviInfo(
                videoInfo.getAid().toString(),
                videoInfo.getBvId(),
                null,
                null,
                videoInfo.getTitle(),
                videoInfo.getUname(),
                videoInfo.getUid(),
                null,
                videoInfo.getCoverUrl(),
                null,
                videoInfo.getPubDate() - 1412092800,
                DateTimeUtils.YMD_DASH_HM_COLON_DTF.format(LocalDateTime.ofEpochSecond(videoInfo.getPubDate(), 0, ZoneOffset.ofHours(8))),
                false,
                false,
                "00:00:00",
                null
        );
    }

    public PlayInfo getPlayInfo(PlayUrlInfo playUrlInfo, VideoInfo videoInfo){
        return new PlayInfo(
                0,
                videoInfo.getAid().toString(),
                videoInfo.getBvId(),
                videoInfo.getCid().toString(),
                null,
                null,
                videoInfo.getGroupTitle(),
                videoInfo.getUname(),
                null,
                videoInfo.getCoverUrl(),
                null,
                "vupload",
                videoInfo.getP().toString(),
                videoInfo.getTitle(),
                2,
                1,
                videoInfo.getPubDate() - 1412092800,
                DateTimeUtils.YMD_DASH_HM_COLON_DTF.format(LocalDateTime.ofEpochSecond(videoInfo.getPubDate(), 0, ZoneOffset.ofHours(8))),
                DateTimeUtils.secondsToHMSMS(playUrlInfo.getData().getTimeLength())+"0000",
                Collections.singletonList(playUrlInfo.getData().getTimeLength()),
                videoInfo.getTotalSize(),
                null,
                true,
                false,
                true,
                new PlayMediaInfo(
                        0,
                        playUrlInfo.getData().getDash().getVideo().get(0).getCodecId(),
                        getCodecName(playUrlInfo.getData().getSupportFormats(), playUrlInfo.getData().getQuality(), playUrlInfo.getData().getFormat()),
                        playUrlInfo.getData().getDash().getVideo().get(0).getWidth(),
                        playUrlInfo.getData().getDash().getVideo().get(0).getHeight(),
                        playUrlInfo.getData().getDash().getVideo().get(0).getBandWidth(),
                        new BigDecimal(playUrlInfo.getData().getDash().getVideo().get(0).getFrameRate())
                ),
                Collections.singletonList(new PlayMediaInfo(
                        1,
                        playUrlInfo.getData().getDash().getAudio().get(0).getCodecId(),
                        playUrlInfo.getData().getDash().getAudio().get(0).getCodecs(),
                        playUrlInfo.getData().getDash().getAudio().get(0).getWidth(),
                        playUrlInfo.getData().getDash().getAudio().get(0).getHeight(),
                        playUrlInfo.getData().getDash().getAudio().get(0).getBandWidth(),
                null
//                        new BigDecimal(playUrlInfo.getData().getDash().getAudio().get(0).getFrameRate())
                ))
        );
    }

    public String getDesktopIniInfo(VideoInfo videoInfo){
        return String.format("[.ShellClassInfo]\nInfoTip=%s\n[ViewState]=\nMode=\nVid=\nFolderType=Generic", videoInfo.getTitle());
    }

    public String getDmInfo(VideoInfo videoInfo){
        return String.format("<?xml version=\"2.0\" encoding=\"UTF-8\"?><i><oid>%d</oid></i>", videoInfo.getItemId());
    }

    private String getCodecName(List<PlayUrlDataFormatInfo> supportFormats, Integer quality, String format){
        List<String> codecList = supportFormats.get(0).getCodecs();
        for(PlayUrlDataFormatInfo supportFormat:supportFormats){
            if(supportFormat.getQuality() == quality && supportFormat.getFormat().equals(format)){
                codecList = supportFormat.getCodecs();
            }
        }
        if(null != codecList && codecList.size() > 0){
            return codecList.get(codecList.size()-1);
        }
        return null;
    }
}
