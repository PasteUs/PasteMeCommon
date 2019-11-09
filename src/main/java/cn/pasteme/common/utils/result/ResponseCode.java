package cn.pasteme.common.utils.result;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lucien, 白振宇
 * @version 1.1.1
 */
@Getter
public enum ResponseCode {
    /**
     * 通用 Response Code
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

    FORBIDDEN(403, "Forbidden"),

    NOT_FOUND(404, "Not Found"),

    METHOD_NOT_ALLOWED(405, "Method Not Allowed");

    private int code;

    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 填充 message
     *
     * @param args 填充参数
     * @return this
     */
    public ResponseCode fillArgs(Object... args) {
        this.message = String.format(this.message, args);
        return this;
    }
}
