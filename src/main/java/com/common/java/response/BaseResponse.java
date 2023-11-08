package com.common.java.response;

/**
 * <b><code>BaseResponse</code></b>
 * <p/>
 * 统一返回结果 BaseResponse
 * <p/>
 * <b>Creation Time:</b> 2023/11/1 22:27
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class BaseResponse {

    private int code;

    private String message;

    public BaseResponse(){

    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
