package cn.pasteme.common.utils.result;

import lombok.Getter;

/**
 * @Author: 白振宇
 * @Date： 2019/9/30 0:17
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
    private String msg;

    public CodeMsg() {

    }

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }
}
