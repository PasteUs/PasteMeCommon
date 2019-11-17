package cn.pasteme.common.utils.result;

import lombok.Getter;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

/**
 * @author Lucien, 白振宇
 * @version 1.0.2
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
    public static <T> Response<T> success(@NotNull T data) {
        return new Response<>(data);
    }

    /**
     * 无参数的成功
     * 有时候只是想返回一个 boolean，又希望出现错误时可以带上错误信息
     *
     * @return Response
     */
    public static Response success() {
        return new Response<>();
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

    public static <T> Response<T> error(Response response) {
        return new Response<>(response);
    }

    private Response(T data) {
        this();
        this.data = data;
    }

    private Response(Response response) {
        Assert.isTrue(!response.isSuccess(), "Error response is required");
        this.data = null;
        this.code = response.code;
        this.message = response.message;
    }

    private Response(ResponseCode responseCode) {
        if (responseCode == null) {
            return;
        }

        this.data = null;
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    private Response() {
        this.code = 0;
        this.message = "success";
    }

    /**
     * isSuccess
     *
     * @return boolean
     */
    public boolean isSuccess() {
        return this.code == 0;
    }

    /**
     * 以字符串形式输出
     *
     * @return Response(code = ${code}, message = ${message}, data = ${data})
     */
    @Override
    public String toString() {
        return "Response(" +
                "code=" + code + ", message=" + message + ", data=" +
                (null == data ? "null" : data.toString()) + ")";
    }
}
