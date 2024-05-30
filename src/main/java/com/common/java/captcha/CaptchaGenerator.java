package com.common.java.captcha;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Random;

/**
 * <b><code>CaptchaGenerator</code></b>
 * <p/>
 * 验证码
 * <p/>
 * <b>Creation Time:</b> 2024/5/30 23:09
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class CaptchaGenerator {
    private int width;
    private int height;
    private int symbolNum;
    private Random random;
    private String [] fontNames;
    private String codes;
    private Color bgColor;

    public CaptchaGenerator(){
        this.width = CaptchaConstants.WIDTH;
        this.height = CaptchaConstants.HEIGHT;
        this.symbolNum = CaptchaConstants.SYMBOL_NUM;
        this.random = new Random();
        this.fontNames = CaptchaConstants.FONT_NAMES;
        this.codes = CaptchaConstants.CODES;
        this.bgColor = CaptchaConstants.BG_COLOR;
    }

    public CaptchaGenerator(int symbolNum, String codes){
        this.width = CaptchaConstants.WIDTH;
        this.height = CaptchaConstants.HEIGHT;
        this.symbolNum = symbolNum;
        this.random = new Random();
        this.fontNames = CaptchaConstants.FONT_NAMES;
        this.codes = codes;
        this.bgColor = CaptchaConstants.BG_COLOR;
    }

    // 生成随机颜色
    private Color randomColor(){
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red,green,blue);
    }

    // 生成随机字体
    private Font randomFont(){
        int index = random.nextInt(fontNames.length);   // 获取下标
        String fontName = fontNames[index];             // 生成随机的字体名称
        int style = random.nextInt(4);           // 获取随机样式，0表示无样式，1表示粗体，2表示斜体，3表示粗体加斜体
        int size = random.nextInt(5) + 24;       // 生成随机字号，24~28
        return new Font(fontName,style,size);
    }

    // 画干扰线
    private void drawLine(BufferedImage image){
        int num = 3;  // 一共画3条
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        for(int i=0;i<num;i++){         // 随机生成坐标，即4个值
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g2.setStroke(new BasicStroke(1.5F));    // 设置笔画的宽度
            g2.setColor(Color.blue);        // 干扰线颜色
            g2.drawLine(x1, y1, x2, y2);    // 画线
        }
    }

    // 随机生成一个字符
    private char randomChar(){
        int index = random.nextInt(codes.length());
        return codes.charAt(index);
    }

    // 创建BufferedImage
    private BufferedImage createImage(){
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(this.bgColor);
        g2.fillRect(0, 0, width,height);
        return image;
    }

    // 生成验证码
    public Map.Entry<String, BufferedImage> generateCaptcha(){
        BufferedImage image = createImage();              // 创建图片缓冲区
        Graphics2D g2 = (Graphics2D)image.getGraphics();  // 得到绘制环境
        StringBuilder sb = new StringBuilder();           // 用来装载生成的验证码文本
        for(int i = 0;i < symbolNum; i++){
            String symbol = String.valueOf(randomChar()); // 随机生成一个字符
            sb.append(symbol);
            double x = i * 1.0 * width / symbolNum + (random.nextInt(width / symbolNum / 5) - (width / symbolNum / 10)); // 设置当前字符的x轴坐标
            Font font = randomFont();
            g2.setFont(font);               // 设置随机字体
            g2.setColor(randomColor());     // 设置随机颜色
            int y = random.nextInt((height - font.getSize())/2) + font.getSize();   // 字符底部到图片顶部的距离
            System.out.println(x + ", " + y);
            g2.drawString(symbol, (int)x, y);
        }
        drawLine(image);                // 添加干扰线
        Map.Entry<String, BufferedImage> entry = new AbstractMap.SimpleEntry(sb.toString(), image);
        return entry;
    }

    // 保存图片到指定的输出流
    public static void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPEG", out);
    }

}
