package com.common.java.exception.base.business;

import com.common.java.exception.base.BaseException;
import com.common.java.exception.base.IExceptionAssertResponseEnum;

/**
 * <b><code>BusinessException</code></b>
 * <p/>
 * 业务异常
 * <p/>
 * <b>Creation Time:</b> 2022/8/24 下午12:34.
 *
 * @author yang xiong
 */
public class CommonException extends BaseException {

    private static final long serialVersionUID = 1L;

    public CommonException(IExceptionAssertResponseEnum exceptionAssertResponseEnum, Object[] args, String message) {
        super(exceptionAssertResponseEnum, args, message);
    }

    public CommonException(IExceptionAssertResponseEnum exceptionAssertResponseEnum, Object[] args, String message, Throwable cause) {
        super(exceptionAssertResponseEnum, args, message, cause);
    }
}
