package com.common.java.captcha;

import java.awt.*;

/**
 * <b><code>CaptchaConstants</code></b>
 * <p/>
 * 验证码常量
 * <p/>
 * <b>Creation Time:</b> 2024/5/30 23:09
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class CaptchaConstants {
    public static final int WIDTH = 70;
    public static final int HEIGHT = 35;
    public static final int SYMBOL_NUM = 4;
    public static final String [] FONT_NAMES = {"宋体","华文楷书","黑体","华文新魏","微软雅黑","华文隶书","楷体_GB2312","Times New Roman"};
    public static final String CODES = "23456789abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";
    public static final Color BG_COLOR=new Color(255,255,255);
}
