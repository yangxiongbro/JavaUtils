package com.common.java.exception.base.business;

import com.common.java.exception.base.BaseException;
import com.common.java.exception.base.IBaseAssert;
import com.common.java.exception.base.IExceptionAssertResponseEnum;

import java.text.MessageFormat;

/**
 * <b><code>AbstractBusinessExceptionAssert</code></b>
 * <p/>
 * 创建异常接口实现类，由于枚举不能继承，所以不能使用抽象类
 * <p/>
 * <b>Creation Time:</b> 2022/8/24 下午12:09.
 *
 * @author yang xiong
 */
public interface IBaseBusinessExceptionFactory extends IExceptionAssertResponseEnum, IBaseAssert {
    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BaseBusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BaseBusinessException(this, args, msg, t);
    }
}
