package com.common.java.date_time;

import com.common.java.constants.DateTimeConstants;

import java.time.format.DateTimeFormatter;

/**
 * <b><code>DateTimeConvertor</code></b>
 * <p/>
 * 时间相关组件
 * <p/>
 * <b>Creation Time:</b> 2024/4/21 2:54
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class DateTimeConvertor {
    private DateTimeConvertor(){

    }

    public static final DateTimeFormatter YMD_DASH_HM_COLON_DTF = DateTimeFormatter.ofPattern(DateTimeConstants.YMD_DASH_HM_COLON);

    public static final DateTimeFormatter YMD_DASH_HMS_COLON_DTF = DateTimeFormatter.ofPattern(DateTimeConstants.YMD_DASH_HMS_COLON);

    /**
     * @description: 毫秒数 转 HH:mm:ss.SSS
     * @param: ms - [Integer]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2024/4/21 3:22
     **/
    public static String secondsToHMSMS(Integer ms){
        Integer seconds = ms / 1000;
        Integer hours = seconds / 3600;
        Integer minutes = (seconds % 3600) / 60;
        Integer secs = seconds % 60;
        Integer msecs = ms % 1000;
        return String.format("%02d:%02d:%02d.%03d", hours, minutes, secs, msecs);
    }
}
