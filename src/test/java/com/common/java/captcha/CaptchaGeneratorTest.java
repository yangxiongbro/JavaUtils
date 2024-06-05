package com.common.java.captcha;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * <b><code>CaptchaUtilsTest</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/5/30 23:00
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class CaptchaGeneratorTest {

    @Test
    public void output() throws IOException {
        CaptchaGenerator captchaGenerator = new CaptchaGenerator();
        Map.Entry<String, BufferedImage> captcha = captchaGenerator.generateCaptcha();
        File file = new File("C:\\Users\\young\\Desktop\\captcha-" + captcha.getKey() + ".jpg");
        FileOutputStream fos = new FileOutputStream(file);
        CaptchaGenerator.output(captcha.getValue(), fos);
        fos.close();
    }
    // https://www.zhihu.com/tardis/bd/art/620969977?source_id=1001
}
