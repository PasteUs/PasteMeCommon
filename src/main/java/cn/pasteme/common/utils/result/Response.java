package cn.pasteme.common.utils.result;

import lombok.Getter;

/**
 * @author 白振宇
 * @version 1.0.0
 */
@Getter
public class Response<T> {

    /**
     * 返回值
     */
    private int code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功时返回信息
     *
     * @param data 数据
     * @param <T>  泛型
     * @return 成功结果
     */
    public static <T> Response<T> success(T data) {
        return new Response<>(data);
    }

    /**
     * 失败时返回信息
     *
     * @param responseCode 错误代码
     * @param <T> 泛型
     * @return 错误代码
     */
    public static <T> Response<T> error(ResponseCode responseCode) {
        return new Response<>(responseCode);
    }

    private Response(T data) {
        this.code = 0;
        this.message = "success";
        this.data = data;
    }

    private Response(ResponseCode responseCode) {
        if (responseCode == null) {
            return;
        }

        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    public Response() {

    }

    /**
     * 以字符串形式输出
     *
     * @return Response(code = ${code}, message = ${message}, data = ${data})
     */

    @Override
    public String toString() {
        return "Response(" +
                "code = " + code + ", message = " + message + ", data = " +
                (null == data ? "null" : data.toString()) + ")";
    }
}
