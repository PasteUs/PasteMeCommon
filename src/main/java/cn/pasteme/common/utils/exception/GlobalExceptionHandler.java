package cn.pasteme.common.utils.exception;

import cn.pasteme.common.utils.result.ResponseCode;
import cn.pasteme.common.utils.result.Response;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Lucien, 白振宇
 * @version 1.0.2
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public static Response exceptionHandler(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException ge = (GlobalException) e;
            return Response.error(ge.getResponseCode());
        } else if (e instanceof org.springframework.validation.BindException) {
            List<ObjectError> errors = ((BindException) e).getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Response.error(ResponseCode.BIND_ERROR.fillArgs(msg));
        } else {
            return Response.error(ResponseCode.SERVER_ERROR);
        }
    }
}
