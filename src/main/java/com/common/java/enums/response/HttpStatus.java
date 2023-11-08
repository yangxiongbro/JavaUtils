package com.common.java.enums.response;

/**
 * <b><code>HttpStatus</code></b>
 * <p/>
 * HttpStatus
 * <p/>
 * <b>Creation Time:</b> 2023/11/7 0:15
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public enum HttpStatus {

    // Continue
    // 继续
    CONTINUE(100),

    // Switching Protocols
    // 切换协议
    SWITCHING_PROTOCOLS(101),

    // Processing
    PROCESSING(102),

    // Checkpoint
    CHECKPOINT(103),

    // OK
    // 请求已完成
    OK(200),

    // Created
    CREATED(201),

    // Accepted
    // 已接受
    ACCEPTED(202),

    // Non-Authoritative Information
    NON_AUTHORITATIVE_INFORMATION(203),

    // No Content
    NO_CONTENT(204),

    // Reset Content
    RESET_CONTENT(205),

    // Partial Content
    PARTIAL_CONTENT(206),

    // Multi-Status
    MULTI_STATUS(207),

    // Already Reported
    ALREADY_REPORTED(208),

    // IM Used
    IM_USED(226),

    // Multiple Choices
    // 多种选择
    MULTIPLE_CHOICES(300),

    // Moved Permanently
    // 永久移动
    MOVED_PERMANENTLY(301),

    // Found
    // 已找到
    FOUND(302),

    // See Other
    // 查看其他位置
    SEE_OTHER(303),

    // Not Modified
    // 未修改
    NOT_MODIFIED(304),

    // Temporary Redirect
    // 临时重定向
    TEMPORARY_REDIRECT(307),

    // Permanent Redirect
    // 永久重定向
    PERMANENT_REDIRECT(308),

    // Bad Request
    // 错误请求
    BAD_REQUEST(400),

    // Unauthorized
    // 未授权
    UNAUTHORIZED(401),

    // Payment Required
    // 需要付款
    PAYMENT_REQUIRED(402),

    // Forbidden
    // 已禁止
    FORBIDDEN(403),

    // Not Found
    // 未找到
    NOT_FOUND(404),

    // Method Not Allowed
    // 方法禁用
    METHOD_NOT_ALLOWED(405),

    // Not Acceptable
    // 不接受
    NOT_ACCEPTABLE(406),

    // Proxy Authentication Required
    // 需要代理授权
    PROXY_AUTHENTICATION_REQUIRED(407),

    // Request Timeout
    // 请求超时
    REQUEST_TIMEOUT(408),

    // Conflict
    // 冲突
    CONFLICT(409),

    // Gone
    GONE(410),

    // Length Required
    // 需要有效长度
    LENGTH_REQUIRED(411),

    // Precondition Failed
    // 未满足前提条件
    PRECONDITION_FAILED(412),

    // Payload Too Large
    // 请求实体过大
    PAYLOAD_TOO_LARGE(413),

    // URI Too Long
    // 请求的URL过长
    URI_TOO_LONG(414),

    // Unsupported Media Type
    // 不支持的媒体类型
    UNSUPPORTED_MEDIA_TYPE(415),

    // Requested range not satisfiable
    // 请求范围不符合要求
    REQUESTED_RANGE_NOT_SATISFIABLE(416),

    // Expectation Failed
    // 未满足期望值
    EXPECTATION_FAILED(417),

    // I'm a teapot
    I_AM_A_TEAPOT(418),

    // Unprocessable Entity
    UNPROCESSABLE_ENTITY(422),

    // Locked
    LOCKED(423),

    // Failed Dependency
    FAILED_DEPENDENCY(424),

    // Too Early
    TOO_EARLY(425),

    // Upgrade Required
    UPGRADE_REQUIRED(426),

    // Precondition Required
    PRECONDITION_REQUIRED(428),

    // Too Many Requests
    TOO_MANY_REQUESTS(429),

    // Request Header Fields Too Large
    REQUEST_HEADER_FIELDS_TOO_LARGE(431),

    // Unavailable For Legal Reasons
    UNAVAILABLE_FOR_LEGAL_REASONS(451),

    // Internal Server Error
    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500),

    // Not Implemented
    // 尚未实现
    NOT_IMPLEMENTED(501),

    // Bad Gateway
    // 错误网关
    BAD_GATEWAY(502),

    // Service Unavailable
    // 错误网关
    SERVICE_UNAVAILABLE(503),

    // Gateway Timeout
    // 网关超时
    GATEWAY_TIMEOUT(504),

    // HTTP Version not supported
    // 不支持HTTP版本
    HTTP_VERSION_NOT_SUPPORTED(505),

    // Variant Also Negotiates
    VARIANT_ALSO_NEGOTIATES(506),

    // Insufficient Storage
    INSUFFICIENT_STORAGE(507),

    // Loop Detected
    LOOP_DETECTED(508),

    // Bandwidth Limit Exceeded
    BANDWIDTH_LIMIT_EXCEEDED(509),

    // Not Extended
    NOT_EXTENDED(510),

    // Network Authentication Required
    NETWORK_AUTHENTICATION_REQUIRED(511);

    private final int value;

    HttpStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
