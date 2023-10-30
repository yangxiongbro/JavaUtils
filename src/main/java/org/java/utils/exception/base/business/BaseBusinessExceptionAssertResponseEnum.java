package org.java.utils.exception.base.business;

/**
 * <b><code>BusinessExceptionAssertResponseEnum</code></b>
 * <p/>
 * 业务异常断言响应枚举
 * <p/>
 * <b>Creation Time:</b> 2022/8/24 下午12:19.
 *
 * @author yang xiong
 */
public enum BaseBusinessExceptionAssertResponseEnum implements IBaseBusinessExceptionFactory {

    /**
     * 通用异常
     */
    EXCEPTION(100001, "{0}"),

    /**
     * 未找到文件
     */
    FILE_NOT_FOUND(200001, "未找到文件:{0}."),

    /**
     * 未找到文件
     */
    FILE_NOT_FOUND_IN_DIR(200002, "在目录:{0},未找到文件:{1}.");

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回消息
     */
    private String message;

    BaseBusinessExceptionAssertResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

