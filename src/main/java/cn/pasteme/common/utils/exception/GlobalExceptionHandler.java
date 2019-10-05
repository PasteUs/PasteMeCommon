package cn.pasteme.common.utils.exception;

import cn.pasteme.common.utils.result.CodeMessage;
import cn.pasteme.common.utils.result.Response;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 白振宇
 * @date 2019/9/29 21:40
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    Response<String> exceptionHandler(HttpServletRequest request, Exception e) {
        if (e instanceof GlobalException) {
            GlobalException ge = (GlobalException) e;
            return Response.error(ge.getCm());
        } else if (e instanceof org.springframework.validation.BindException) {
            List<ObjectError> errors = ((BindException) e).getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Response.error(CodeMessage.BIND_ERROR.fillArgs(msg));
        } else {
            e.printStackTrace();
            return Response.error(CodeMessage.SERVER_ERROR);
        }
    }
}
