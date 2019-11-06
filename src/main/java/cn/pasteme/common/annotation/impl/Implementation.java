package cn.pasteme.common.annotation.impl;

import cn.pasteme.common.annotation.RequestLogging;
import cn.pasteme.common.annotation.Timer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Lucien, Ryan Lee
 * @version 1.0.2
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
        log.info("Timer: [{}:{}] cost {} ms", clazzName, methodName, endTime - startTime);
        return response;
    }

    @Around("@annotation(logging)")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint, RequestLogging logging) throws Throwable {
        String clazzName = proceedingJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object response = proceedingJoinPoint.proceed();
        if (logging.withResponse()) {
            log.info("ParamLog: [{}:{}({})] return: {}", clazzName, methodName, proceedingJoinPoint.getArgs(), response);
        }
        else {
            log.info("ParamLog: [{}:{}({})]", clazzName, methodName, proceedingJoinPoint.getArgs());
        }
        return response;
    }
}
