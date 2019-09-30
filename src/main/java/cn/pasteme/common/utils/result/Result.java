package cn.pasteme.common.utils.result;

import lombok.Getter;

/**
 * @Author: 白振宇
 * @Date： 2019/9/29 23:51
 */
@Getter
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    /**
     * 成功时返回信息
     * @param data 数据
     * @param <T> 泛型
     * @return 成功结果
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    /**
     * 失败是返回信息
     * @param codeMsg 错误代码
     * @param <T> 泛型
     * @return 错误代码
     */
    public static <T> Result<T> error(CodeMsg codeMsg) {
        return new Result<>(codeMsg);
    }

    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }


    private Result(CodeMsg codeMsg) {
        if(codeMsg==null) {
            return;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }

    public Result() {

    }
}
