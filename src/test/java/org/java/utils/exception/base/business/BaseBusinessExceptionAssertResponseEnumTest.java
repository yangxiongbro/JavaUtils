package org.java.utils.exception.base.business;

import org.java.utils.exception.base.BaseException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <b><code>BaseBusinessExceptionAssertResponseEnumTest</code></b>
 * <p/>
 * BaseBusinessExceptionAssertResponseEnumTest
 * <p/>
 * <b>Creation Time:</b> 2023/10/31 0:13
 *
 * @author yang xiong
 * @since JavaUtils 1.0
 */
public class BaseBusinessExceptionAssertResponseEnumTest {
    @Test
    public void assertNotNull() throws BaseException {
        Object obj = null;
        BaseBusinessExceptionAssertResponseEnum.FILE_NOT_FOUND.assertNotNull(obj, "消息");
    }

    @Test
    public void assertNotNull2() throws BaseException {
        Object obj = null;
        BaseBusinessExceptionAssertResponseEnum.FILE_NOT_FOUND_IN_DIR.assertNotNull(obj, "目录", "文件名");
    }

    @Test
    public void assertNull() throws BaseException {
        Object obj = new Object();
        BaseBusinessExceptionAssertResponseEnum.EXCEPTION.assertNull(obj, "消息");
    }

    @Test
    public void assertFalse() throws BaseException {
        Boolean flag = true;
        BaseBusinessExceptionAssertResponseEnum.EXCEPTION.assertFalse(flag, "消息");
    }

    @Test
    public void assertTrue() throws BaseException {
        Boolean flag = false;
        BaseBusinessExceptionAssertResponseEnum.EXCEPTION.assertTrue(flag, "消息");
    }

    @Test
    public void assertNotEmpty() throws BaseException {
        List<Object> list = null;
        BaseBusinessExceptionAssertResponseEnum.EXCEPTION.assertNotEmpty(list, "消息");
    }

    @Test
    public void assertNotEmpty2() throws BaseException {
        List<Object> list = new ArrayList<>();
        BaseBusinessExceptionAssertResponseEnum.EXCEPTION.assertNotEmpty(list, "消息");
    }

    @Test
    public void assertEmpty() throws BaseException {
        List<Object> list = Collections.singletonList(new Object());
        BaseBusinessExceptionAssertResponseEnum.EXCEPTION.assertEmpty(list, "消息");
    }

}
