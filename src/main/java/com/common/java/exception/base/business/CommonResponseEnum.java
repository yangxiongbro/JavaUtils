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
public enum CommonResponseEnum implements ICommonExceptionFactory {

    /**
     * Continue
     * 继续
      */
    CONTINUE(1000000, "{0}"),

    /**
     * Switching Protocols
     * 切换协议
      */
    SWITCHING_PROTOCOLS(1010000, "{0}"),

    /**
     * Processing
      */
    PROCESSING(1020000, "{0}"),

    /**
     * Checkpoint
      */
    CHECKPOINT(1030000, "{0}"),

    /**
     * OK
     * 请求已完成
      */
    OK(2000000, "{0}"),

    /**
     * Created
      */
    CREATED(2010000, "{0}"),

    /**
     * Accepted
     * 已接受
      */
    ACCEPTED(2020000, "{0}"),

    /**
     * Non-Authoritative Information
      */
    NON_AUTHORITATIVE_INFORMATION(2030000, "{0}"),

    /**
     * No Content
      */
    NO_CONTENT(2040000, "{0}"),

    /**
     * Reset Content
      */
    RESET_CONTENT(2050000, "{0}"),

    /**
     * Partial Content
      */
    PARTIAL_CONTENT(2060000, "{0}"),

    /**
     * Multi-Status
      */
    MULTI_STATUS(2070000, "{0}"),

    /**
     * Already Reported
      */
    ALREADY_REPORTED(2080000, "{0}"),

    /**
     * IM Used
      */
    IM_USED(2260000, "{0}"),

    /**
     * Multiple Choices
     * 多种选择
      */
    MULTIPLE_CHOICES(3000000, "{0}"),

    /**
     * Moved Permanently
     * 永久移动
      */
    MOVED_PERMANENTLY(3010000, "{0}"),

    /**
     * Found
     * 已找到
      */
    FOUND(3020000, "{0}"),

    /**
     * See Other
     * 查看其他位置
      */
    SEE_OTHER(3030000, "{0}"),

    /**
     * Not Modified
     * 未修改
      */
    NOT_MODIFIED(3040000, "{0}"),

    /**
     * Temporary Redirect
     * 临时重定向
      */
    TEMPORARY_REDIRECT(3070000, "{0}"),

    /**
     * Permanent Redirect
     * 永久重定向
      */
    PERMANENT_REDIRECT(3080000, "{0}"),

    /**
     * Bad Request
     * 错误请求
      */
    BAD_REQUEST(4000000, "{0}"),

    /**
     * Unauthorized
     * 未授权
      */
    UNAUTHORIZED(4010000, "{0}"),

    /**
     * Payment Required
     * 需要付款
      */
    PAYMENT_REQUIRED(4020000, "{0}"),

    /**
     * Forbidden
     * 已禁止
      */
    FORBIDDEN(4030000, "{0}"),

    /**
     * Not Found
     * 未找到
      */
    NOT_FOUND(4040000, "{0}"),

    /**
     * Method Not Allowed
     * 方法禁用
      */
    METHOD_NOT_ALLOWED(4050000, "{0}"),

    /**
     * Not Acceptable
     * 不接受
     */
    NOT_ACCEPTABLE(4060000, "{0}"),

    /**
     * Proxy Authentication Required
     * 需要代理授权
     */
    PROXY_AUTHENTICATION_REQUIRED(4070000, "{0}"),

    /**
     * Request Timeout
     * 请求超时
     */
    REQUEST_TIMEOUT(4080000, "{0}"),

    /**
     * Conflict
     * 冲突
     */
    CONFLICT(4090000, "{0}"),

    /**
     * Gone
     */
    GONE(4100000, "{0}"),

    /**
     * Length Required
     * 需要有效长度
     */
    LENGTH_REQUIRED(4110000, "{0}"),

    /**
     * Precondition Failed
     * 未满足前提条件
     */
    PRECONDITION_FAILED(4120000, "{0}"),

    /**
     * Payload Too Large
     * 请求实体过大
     */
    PAYLOAD_TOO_LARGE(4130000, "{0}"),

    /**
     * URI Too Long
     * 请求的URL过长
     */
    URI_TOO_LONG(4140000, "{0}"),

    /**
     * Unsupported Media Type
     * 不支持的媒体类型
     */
    UNSUPPORTED_MEDIA_TYPE(4150000, "{0}"),

    /**
     * Requested range not satisfiable
     * 请求范围不符合要求
     */
    REQUESTED_RANGE_NOT_SATISFIABLE(4160000, "{0}"),

    /**
     * Expectation Failed
     * 未满足期望值
     */
    EXPECTATION_FAILED(4170000, "{0}"),

    /**
     * I'm a teapot
     */
    I_AM_A_TEAPOT(4180000, "{0}"),

    /**
     * Unprocessable Entity
     */
    UNPROCESSABLE_ENTITY(4220000, "{0}"),

    /**
     * Locked
     */
    LOCKED(4230000, "{0}"),

    /**
     * Failed Dependency
     */
    FAILED_DEPENDENCY(4240000, "{0}"),

    /**
     * Too Early
     */
    TOO_EARLY(4250000, "{0}"),

    /**
     * Upgrade Required
     */
    UPGRADE_REQUIRED(4260000, "{0}"),

    /**
     * Precondition Required
     */
    PRECONDITION_REQUIRED(4280000, "{0}"),

    /**
     * Too Many Requests
     */
    TOO_MANY_REQUESTS(4290000, "{0}"),

    /**
     * Request Header Fields Too Large
     */
    REQUEST_HEADER_FIELDS_TOO_LARGE(4310000, "{0}"),

    /**
     * Unavailable For Legal Reasons
     */
    UNAVAILABLE_FOR_LEGAL_REASONS(4510000, "{0}"),

    /**
     * Internal Server Error
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(5000000, "{0}"),

    /**
     * Not Implemented
     * 尚未实现
     */
    NOT_IMPLEMENTED(5010000, "{0}"),

    /**
     * Bad Gateway
     * 错误网关
     */
    BAD_GATEWAY(5020000, "{0}"),

    /**
     * Service Unavailable
     * 错误网关
     */
    SERVICE_UNAVAILABLE(5030000, "{0}"),

    /**
     * Gateway Timeout
     * 网关超时
     */
    GATEWAY_TIMEOUT(5040000, "{0}"),

    /**
     * HTTP Version not supported
     * 不支持HTTP版本
     */
    HTTP_VERSION_NOT_SUPPORTED(5050000, "{0}"),

    /**
     * Variant Also Negotiates
     */
    VARIANT_ALSO_NEGOTIATES(5060000, "{0}"),

    /**
     * Insufficient Storage
     */
    INSUFFICIENT_STORAGE(5070000, "{0}"),

    /**
     * Loop Detected
     */
    LOOP_DETECTED(5080000, "{0}"),

    /**
     * Bandwidth Limit Exceeded
     */
    BANDWIDTH_LIMIT_EXCEEDED(5090000, "{0}"),

    /**
     * Not Extended
     */
    NOT_EXTENDED(5100000, "{0}"),

    /**
     * Network Authentication Required
      */
    NETWORK_AUTHENTICATION_REQUIRED(5110000, "{0}"),

    /**
     * 未找到文件
      */
    FILE_NOT_FOUND(4040001, "未找到文件:{0}."),

    /**
     * 未找到文件
      */
    FILE_NOT_FOUND_IN_DIR(4040002, "在目录:{0},未找到文件:{1}.");

    /**
     * 返回码
      */
    private int code;

    /**
     * 返回消息
      */
    private String message;

    CommonResponseEnum(int code, String message) {
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

