package com.common.java.exception.base.business;

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
    EXCEPTION(5000001, "{0}"),

    /**
     * 未找到文件
     */
    NOT_FOUND_FILE(4040001, "未找到文件:{0}."),

    /**
     * 未找到文件
     */
    NOT_FOUND_FILE_IN_DIR(4040002, "在目录:{0},未找到文件:{1}.");

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

