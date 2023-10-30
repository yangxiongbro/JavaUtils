package org.java.utils.exception.base.business;

import org.java.utils.exception.base.BaseException;
import org.java.utils.exception.base.IExceptionAssertResponseEnum;

/**
 * <b><code>BusinessException</code></b>
 * <p/>
 * 业务异常
 * <p/>
 * <b>Creation Time:</b> 2022/8/24 下午12:34.
 *
 * @author yang xiong
 */
public class BaseBusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BaseBusinessException(IExceptionAssertResponseEnum exceptionAssertResponseEnum, Object[] args, String message) {
        super(exceptionAssertResponseEnum, args, message);
    }

    public BaseBusinessException(IExceptionAssertResponseEnum exceptionAssertResponseEnum, Object[] args, String message, Throwable cause) {
        super(exceptionAssertResponseEnum, args, message, cause);
    }
}
