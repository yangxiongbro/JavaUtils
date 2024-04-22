package com.common.java.tools.bilibili_convertor;

import com.common.java.utils.DateTimeUtils;
import com.common.java.utils.FilesUtils;
import com.common.java.utils.StringsUtils;
import com.common.java.vo.bilibili_convertor.desktop.*;
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

    private ObjectMapper mapper = new ObjectMapper();

    public void convert(String target, Map<String, List<VideoInfo>> videoInfoMap, Map<String, Map<Long, PlayUrlInfo>> playUrlInfoMap, Map<String, Map<Long, File>> coverFileMap) throws JsonProcessingException {
        FilesUtils.mkdirs(target);
        Comparator comparator = new Comparator<VideoInfo>() {
            @Override
            public int compare(VideoInfo o1, VideoInfo o2) {
                return o1.getP() - o2.getP();
            }
        };

        for(Map.Entry<String, List<VideoInfo>> videoInfoGroupEntry:videoInfoMap.entrySet()){
            String groupId = videoInfoGroupEntry.getKey();
            List<VideoInfo> videoInfoList = videoInfoGroupEntry.getValue();
            Collections.sort(videoInfoList, comparator);
            Map<Long, PlayUrlInfo> playUrlInfoGroupMap = playUrlInfoMap.get(groupId);
            Map<Long, File> coverFileGroupMap = coverFileMap.get(groupId);
            VideoInfo firstVideoInfo = videoInfoList.get(0);

            DviInfo dviInfo = getDviInfo(firstVideoInfo);
            String desktopIniInfo = getDesktopIniInfo(firstVideoInfo);

            Long groupAid = firstVideoInfo.getAid();
            String videoInfoDir = target + "\\" + groupAid;
            System.out.println(videoInfoDir);
            FilesUtils.mkdir(videoInfoDir);
            FilesUtils.writeAllLinesUseNio(videoInfoDir + "\\" + groupAid + ".dvi",
                    mapper.writeValueAsString(dviInfo), FilesUtils.CHARSET_NAME, StandardOpenOption.CREATE);
            FilesUtils.writeAllLinesUseNio(videoInfoDir + "\\desktop.ini",
                    desktopIniInfo, FilesUtils.CHARSET_NAME, StandardOpenOption.CREATE);
            File coverFile = coverFileGroupMap.get(groupAid);
            if(null != coverFile && coverFile.exists()){
                FilesUtils.copyUseNio(coverFile.getPath(), videoInfoDir + "\\cover.jpg", StandardCopyOption.REPLACE_EXISTING);
            }
            boolean IsSinglePart = videoInfoList.size() > 1 ? false : true;
            for(VideoInfo videoInfo:videoInfoList){
                Long aid = videoInfo.getAid();
                PlayUrlInfo playUrlInfo = playUrlInfoGroupMap.get(aid);
                System.out.println(videoInfo);
                System.out.println(playUrlInfo);
                String dmInfo = getDmInfo(videoInfo);
                PlayInfo playInfo = getPlayInfo(playUrlInfo, videoInfo, IsSinglePart);

                Integer p = videoInfo.getP();
                String playInfoDir = videoInfoDir + "\\" + p;
                FilesUtils.mkdir(playInfoDir);

                FilesUtils.writeAllLinesUseNio(playInfoDir + "\\" + groupAid + "_" + p + ".xml",
                        dmInfo, FilesUtils.CHARSET_NAME, StandardOpenOption.CREATE);
                FilesUtils.writeAllLinesUseNio(playInfoDir + "\\" + groupAid + ".info",
                        mapper.writeValueAsString(playInfo), FilesUtils.CHARSET_NAME, StandardOpenOption.CREATE);
                FilesUtils.writeAllLinesUseNio(playInfoDir + "\\" + videoInfo.getTitle() + ".txt",
                        videoInfo.getTitle(), FilesUtils.CHARSET_NAME, StandardOpenOption.CREATE);
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

    public void parseInfo(Map<String, Map<String, File>> pathFileMap,
                          Map<String, List<VideoInfo>> videoInfoMap, Map<String, Map<Long, PlayUrlInfo>> playUrlInfoMap, Map<String, Map<Long, File>> coverFileMap) throws JsonProcessingException {
        for(Map.Entry<String, Map<String, File>> pathFileEntry: pathFileMap.entrySet()) {
            Map<String, File> pathMap = pathFileEntry.getValue();
            File playUrlFile = pathMap.get(".playurl");
            File videoInfoFile = pathMap.get(".videoInfo");
            File coverFile = pathMap.get("image.jpg");
            if (null == playUrlFile || null == videoInfoFile || !playUrlFile.exists() || !videoInfoFile.exists()) {
                continue;
            }
            PlayUrlInfo playUrlInfo = mapper.readValue(FilesUtils.readStringUseNio(playUrlFile.getPath(), FilesUtils.CHARSET_NAME), PlayUrlInfo.class);
            VideoInfo videoInfo = mapper.readValue(FilesUtils.readStringUseNio(videoInfoFile.getPath(), FilesUtils.CHARSET_NAME), VideoInfo.class);
            videoInfoMap.computeIfAbsent(videoInfo.getGroupId(), k -> new ArrayList<>()).add(videoInfo);
            playUrlInfoMap.computeIfAbsent(videoInfo.getGroupId(), k -> new HashMap()).put(videoInfo.getAid(), playUrlInfo);
            coverFileMap.computeIfAbsent(videoInfo.getGroupId(), k -> new HashMap()).put(videoInfo.getAid(), coverFile);
        }
    }

    public DviInfo getDviInfo(VideoInfo videoInfo){
        return new DviInfo(
                videoInfo.getAid().toString(),
                videoInfo.getBvId(),
                null,
                null,
                videoInfo.getGroupTitle(),
                videoInfo.getUname(),
                videoInfo.getUid(),
                null,
                videoInfo.getGroupCoverUrl(),
                null,
                videoInfo.getPubDate() - 1412092800,
                DateTimeUtils.YMD_DASH_HM_COLON_DTF.format(LocalDateTime.ofEpochSecond(videoInfo.getPubDate(), 0, ZoneOffset.ofHours(8))),
                false,
                false,
                "00:00:00",
                null
        );
    }

    public PlayInfo getPlayInfo(PlayUrlInfo playUrlInfo, VideoInfo videoInfo, boolean IsSinglePart){
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
                IsSinglePart,
                false,
                true,
                getVideoInfo(playUrlInfo),
                Collections.singletonList(getAudioInfo(playUrlInfo))
        );
    }

    public String getDesktopIniInfo(VideoInfo videoInfo){
        return String.format("[.ShellClassInfo]\nInfoTip=%s\n[ViewState]=\nMode=\nVid=\nFolderType=Generic", videoInfo.getGroupTitle());
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

    private PlayMediaInfo getAudioInfo(PlayUrlInfo playUrlInfo){
        PlayUrlDataInfo playUrlDataInfo = playUrlInfo.getData();
        if(null == playUrlDataInfo){
            return PlayMediaInfo.getDefaultAudioInfo();
        }
        PlayUrlDataDashInfo playUrlDataDashInfo = playUrlDataInfo.getDash();
        if(null == playUrlDataDashInfo){
            return PlayMediaInfo.getDefaultAudioInfo();
        }
        List<PlayUrlDataDashMediaInfo> playUrlDataDashMediaInfoList = playUrlDataDashInfo.getAudio();
        if(null == playUrlDataDashMediaInfoList || playUrlDataDashMediaInfoList.size()<1){
            return PlayMediaInfo.getDefaultAudioInfo();
        }
        PlayUrlDataDashMediaInfo playUrlDataDashMediaInfo = playUrlDataDashMediaInfoList.get(0);
        if(null == playUrlDataDashMediaInfo){
            return PlayMediaInfo.getDefaultAudioInfo();
        }

        return new PlayMediaInfo(
                1,
                playUrlDataDashMediaInfo.getCodecId(),
                playUrlDataDashMediaInfo.getCodecs(),
                playUrlDataDashMediaInfo.getWidth(),
                playUrlDataDashMediaInfo.getHeight(),
                playUrlDataDashMediaInfo.getBandWidth(),
                new BigDecimal(StringsUtils.isNotEmpty(playUrlDataDashMediaInfo.getFrameRate())?playUrlDataDashMediaInfo.getFrameRate():"0.0")
        );
    }

    private PlayMediaInfo getVideoInfo(PlayUrlInfo playUrlInfo){
        PlayUrlDataInfo playUrlDataInfo = playUrlInfo.getData();
        if(null == playUrlDataInfo){
            return PlayMediaInfo.getDefaultVideoInfo();
        }
        PlayUrlDataDashInfo playUrlDataDashInfo = playUrlDataInfo.getDash();
        if(null == playUrlDataDashInfo){
            return PlayMediaInfo.getDefaultVideoInfo();
        }
        List<PlayUrlDataDashMediaInfo> playUrlDataDashMediaInfoList = playUrlDataDashInfo.getVideo();
        if(null == playUrlDataDashMediaInfoList || playUrlDataDashMediaInfoList.size()<1){
            return PlayMediaInfo.getDefaultVideoInfo();
        }
        PlayUrlDataDashMediaInfo playUrlDataDashMediaInfo = playUrlDataDashMediaInfoList.get(0);
        if(null == playUrlDataDashMediaInfo){
            return PlayMediaInfo.getDefaultVideoInfo();
        }

        return new PlayMediaInfo(
                0,
                playUrlDataDashMediaInfo.getCodecId(),
                getCodecName(playUrlDataInfo.getSupportFormats(), playUrlDataInfo.getQuality(), playUrlDataInfo.getFormat()),
                playUrlDataDashMediaInfo.getWidth(),
                playUrlDataDashMediaInfo.getHeight(),
                playUrlDataDashMediaInfo.getBandWidth(),
                new BigDecimal(StringsUtils.isNotEmpty(playUrlDataDashMediaInfo.getFrameRate())?playUrlDataDashMediaInfo.getFrameRate():"0.0")
        );
    }

}
