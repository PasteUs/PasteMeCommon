package cn.pasteme.common.utils.result;

import lombok.Getter;

/**
 * @author 白振宇
 * @date 2019/09/30 00:17
 */
@Getter
public class CodeMessage {
    /**
     * 通用异常
     */
    public static CodeMessage SUCCESS = new CodeMessage(0, "success");

    public static CodeMessage SERVER_ERROR = new CodeMessage(500100, "服务器端异常");

    public static CodeMessage BIND_ERROR = new CodeMessage(500101, "参数校验异常: %s");

    public static CodeMessage PARAM_ERROR = new CodeMessage(500102, "传递参数异常");

    public static CodeMessage CONTENT_EMPTY = new CodeMessage(500103, "没有此 key 或密码错误");

    public static CodeMessage WRONG_PASSWORD = new CodeMessage(500104, "密码错误");

    private int code;

    private String message;

    private CodeMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CodeMessage fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.message, args);
        return new CodeMessage(code, message);
    }
}
