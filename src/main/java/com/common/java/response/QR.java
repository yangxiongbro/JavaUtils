package com.common.java.response;

/**
 * <b><code>QR</code></b>
 * <p/>
 * 统一返回结果 QueryDataResponse
 * <p/>
 * <b>Creation Time:</b> 2023/11/2 0:01
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class QR<T> extends R<QueryData<T>>{

    public QR() {
        super();
    }

    public QR(QueryData<T> data) {
        super(data);
    }

    public QR(int code, String message, QueryData<T> data) {
        super(code, message, data);
    }
}
