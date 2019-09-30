package cn.pasteme.common.utils.result;

import lombok.Getter;

/**
 * Created by 白振宇 on 2019/9/30 00:17
 */
@Getter
public class CodeMsg {
    /**
     * 通用异常
     */
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");

    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务器端异常");

    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常:%s");

    public static CodeMsg PARAM_ERROR = new CodeMsg(500102, "传递参数异常");

    public static CodeMsg CONTENT_EMPTY = new CodeMsg(500103, "没有此Key或密码错误");

    private int code;

    private String message;

    private CodeMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.message, args);
        return new CodeMsg(code, message);
    }
}
