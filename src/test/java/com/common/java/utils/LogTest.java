package com.common.java.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b><code>LogTest</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2023/11/20 23:33
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Slf4j
public class LogTest {
    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void slf4jApiTest() {
        logger.info("Current Time:" + System.currentTimeMillis());
        logger.info("Current Time: {}", System.currentTimeMillis());
        logger.trace("trace log");
        logger.warn("warn log");
        logger.debug("debug log");
        logger.info("info log");
        logger.error("error log");
    }

    /**
     * 需要导入 lombok 包，以及使用 @Slf4j 注解
     **/
    @Test
    public void lombokLogTest() {
        log.info("Current Time:" + System.currentTimeMillis());
        log.info("Current Time: {}", System.currentTimeMillis());
        log.trace("trace log");
        log.warn("warn log");
        log.debug("debug log");
        log.info("info log");
        log.error("error log");
    }
}
