package com.common.java.response;

/**
 * <b><code>ErrorResponse</code></b>
 * <p/>
 * 统一返回结果 ErrorResponse
 * <p/>
 * <b>Creation Time:</b> 2023/11/3 2:30
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class ER extends BaseResponse{
    public ER(int code, String message) {
        super(code, message);
    }
}
