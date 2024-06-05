package com.common.java.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * <b><code>ThreadsTools</code></b>
 * <p/>
 * 线程有关工具方法类
 * <p/>
 * <b>Creation Time:</b> 2023/11/14 0:18
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Slf4j
public class ThreadsTools {

    /**
     * @description: Thread.sleep(millis)
     * @param: millis - [long]
     * @return: boolean
     * @throws
     * @author yang xiong
     * @date 2023/11/21 22:10
     **/
    public static boolean sleep(long millis) {
        boolean result = true;
        log.info("休眠: {}ms", millis);
        if (millis > 0L) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                log.error("sleep 发生异常：{}", e);
                result = false;
            }
        }
        return result;
    }
}
