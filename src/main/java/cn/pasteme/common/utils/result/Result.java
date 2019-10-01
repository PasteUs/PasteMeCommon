package cn.pasteme.common.utils.result;

import lombok.Getter;

/**
 * @author 白振宇
 * @date 2019/9/29 23:51
 */
@Getter
public class Result<T> {

    // 返回值
    private int code;

    // 返回信息
    private String message;

    // 返回数据
    private T data;

    /**
     * 成功时返回信息
     *
     * @param data 数据
     * @param <T>  泛型
     * @return 成功结果
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    /**
     * 失败时返回信息
     *
     * @param codeMsg 错误代码
     * @param <T> 泛型
     * @return 错误代码
     */
    public static <T> Result<T> error(CodeMsg codeMsg) {
        return new Result<>(codeMsg);
    }

    private Result(T data) {
        this.code = 0;
        this.message = "success";
        this.data = data;
    }


    private Result(CodeMsg codeMsg) {
        if (codeMsg == null) {
            return;
        }

        this.code = codeMsg.getCode();
        this.message = codeMsg.getMessage();
    }

    public Result() {

    }
}
