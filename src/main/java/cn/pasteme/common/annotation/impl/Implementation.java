package cn.pasteme.common.annotation.impl;

import cn.pasteme.common.annotation.ErrorLogging;
import cn.pasteme.common.annotation.RequestLogging;
import cn.pasteme.common.annotation.Timer;
import cn.pasteme.common.utils.exception.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lucien, Ryan Lee, Moyu
 * @version 1.0.3
 */
@Slf4j
@Aspect
@Component
public class Implementation {

    @Around("@annotation(timer)")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint, Timer timer) throws Throwable {
        String clazzName = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();
        Object response = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("Timer: [{}@{}] cost {} ms", clazzName, methodName, endTime - startTime);
        return response;
    }

    @Around("@annotation(logging)")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint, RequestLogging logging) throws Throwable {
        String clazzName = proceedingJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object response = proceedingJoinPoint.proceed();
        if (logging.withResponse()) {
            log.info("ParamLog: [{}@{}({})] return: {}", clazzName, methodName, proceedingJoinPoint.getArgs(), response);
        }
        else {
            log.info("ParamLog: [{}@{}({})]", clazzName, methodName, proceedingJoinPoint.getArgs());
        }
        return response;
    }

    @Around("@annotation(logging)")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint, ErrorLogging logging) throws Throwable {
        Class clazz = proceedingJoinPoint.getTarget().getClass();
        String clazzName = clazz.getSimpleName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object response = null;
        try {
            response = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            log.error("ErrorLog: [{}@{}({})], Exception: ", clazzName, methodName, proceedingJoinPoint.getArgs(), e);
            if (clazz.isAnnotationPresent(RestController.class) || clazz.isAnnotationPresent(Controller.class)) {
                return GlobalExceptionHandler.exceptionHandler(e);
            }
        }
        return response;
    }
}
