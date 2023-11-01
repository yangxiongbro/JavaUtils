package com.common.java.response;

/**
 * <b><code>CommonResponse</code></b>
 * <p/>
 * 统一返回结果 CommonResponse
 * <p/>
 * <b>Creation Time:</b> 2023/11/1 22:30
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class R<T> extends BaseResponse{

    private T data;

    public R(int code, String message) {
        super(code, message);
    }
}
