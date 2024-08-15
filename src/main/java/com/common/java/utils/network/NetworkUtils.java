package com.common.java.utils.network;

import java.util.ArrayList;
import java.util.List;

/**
 * <b><code>NetworkUtils</code></b>
 * <p/>
 * 网络相关
 * <p/>
 * <b>Creation Time:</b> 2024/8/15 15:27
 *
 * @author yang xiong
 * @since CommonJava 0.1.0
 */
public class NetworkUtils {

    public static final Long MAX_IPV4_NUMBER=4294967295L;

    public static final String DEC_IP_NUM_REG="^[1-9]\\d{0,9}$";

    public static final String HEX_IP_NUM_REG="^[0-9a-fA-F]{1,8}$";

    public static final String IPV4_REG="^(((\\d)|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((\\d)|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))$";

    /**
     * @description: 16 进制 数字转 ipv4
     * @param: hexNumberStr
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2024/8/15 15:30
     **/
    public static String hex2FormatIp(String hexNumberStr){
        return null == hexNumberStr || !hexNumberStr.matches(HEX_IP_NUM_REG) ? null : formatIp(Long.parseLong(hexNumberStr,16));
    }

    /**
     * @description: 10 进制数字转 ipv4
     * @param: decNumberStr
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2024/8/15 15:30
     **/
    public static String dec2FormatIp(Number decNumber){
        return null == decNumber ? null : formatIp(decNumber.longValue());
    }

    /**
     * @description: 10 进制数字转 ipv4
     * @param: numberIp
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2024/8/15 16:42
     **/
    public static String formatIp(Long numberIp){
        if(null == numberIp || numberIp > MAX_IPV4_NUMBER){
            return null;
        }
        return (numberIp >> 24) + "." + (numberIp >> 16 & 0xFF) + "." + (numberIp >> 8 & 0xFF) + "." + (numberIp & 0xFF);
    }

    /**
     * @description: ipv4 转 16 进制
     * @param: formatIp
     * @return: java.lang.Long
     * @throws
     * @author yang xiong
     * @date 2024/8/15 16:09
     **/
    public static String formatIp2Hex(String formatIp){
        return String.format("%x", formatIp2Dec(formatIp));
    }

    /**
     * @description: ipv4 转 10 进制
     * @param: formatIp
     * @return: java.lang.Long
     * @throws
     * @author yang xiong
     * @date 2024/8/15 16:26
     **/
    public static Long formatIp2Dec(String formatIp){
        if(null == formatIp || !formatIp.matches(IPV4_REG)) {
            return null;
        }
        String[] ipSegs = formatIp.split("\\.");
        if(null == ipSegs || ipSegs.length < 4){
            return null;
        }
        return Long.valueOf(ipSegs[0]) << 24 | Long.valueOf(ipSegs[1]) << 16 | Long.valueOf(ipSegs[2]) << 8 | Long.valueOf(ipSegs[3]);
    }
}
