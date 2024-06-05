package com.common.java.date_time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * <b><code>DateTimeConvertorTest</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/6/5 22:31
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Slf4j
public class DateTimeConvertorTest {

    @Test
    public void secondsToHMSMS(){
        log.info("{}", DateTimeConvertor.secondsToHMSMS(0));
    }
}
