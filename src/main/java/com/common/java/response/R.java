package com.common.java.response;

import com.common.java.exception.base.business.CommonResponseEnum;

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

    public R(){

    }

    public R(T data) {
        this(CommonResponseEnum.OK.getCode(), CommonResponseEnum.OK.toString(), data);
    }

    public R(int code, String message, T data) {
        super(code, message);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
