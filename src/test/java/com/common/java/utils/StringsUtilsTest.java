package com.common.java.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * <b><code>StringsUtilsTest</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2023/11/21 23:17
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
@Slf4j
public class StringsUtilsTest {

    @Test
    public void lowerCamelCase(){
        String str[] = new String[]{"first", "name"};
        log.info("{}", StringsUtils.lowerCamelCase(str));
    }
}
