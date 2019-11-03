package cn.pasteme.common.utils.result;

import lombok.Getter;

/**
 * @author 白振宇
 * @version 1.0.0
 */
@Getter
public class ResponseCode {
    /**
     * 通用异常
     */
    public static ResponseCode SUCCESS = new ResponseCode(0, "success");

    public static ResponseCode SERVER_ERROR = new ResponseCode(500100, "服务器端异常");

    public static ResponseCode BIND_ERROR = new ResponseCode(500101, "参数校验异常: %s");

    public static ResponseCode PARAM_ERROR = new ResponseCode(500102, "传递参数异常");

    public static ResponseCode CONTENT_EMPTY = new ResponseCode(500103, "没有此 key 或密码错误");

    public static ResponseCode WRONG_PASSWORD = new ResponseCode(500104, "密码错误");

    private int code;

    private String message;

    protected ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseCode fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.message, args);
        return new ResponseCode(code, message);
    }
}
