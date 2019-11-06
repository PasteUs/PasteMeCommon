package cn.pasteme.common.utils.result;

import lombok.Getter;

/**
 * @author Lucien, 白振宇
 * @version 1.1.0
 */
public enum ResponseCode {
    /**
     * 通用异常
     */
    SUCCESS(0, "success"),

    SERVER_ERROR(500100, "服务器端异常"),

    BIND_ERROR(500101, "参数校验异常: %s"),

    PARAM_ERROR(500102, "传递参数异常"),

    CONTENT_EMPTY(500103, "没有此 key 或密码错误"),

    WRONG_PASSWORD(500104, "密码错误"),

    OK(200, "OK"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    UNAUTHORIZED(401, "Unauthorized"),

    NOT_FOUND(404, "404 Not Found"),

    METHOD_NOT_ALLOWED(405, "Method Not Allowed");

    @Getter
    private int code;

    @Getter
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
