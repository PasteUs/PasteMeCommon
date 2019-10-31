package cn.pasteme.common.service;

import cn.pasteme.common.annotation.RequestLogging;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import com.google.common.collect.Lists;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Lucien, Ryan Lee
 * @version 1.0.1
 */
@Slf4j
@Aspect
@Component
public class ServiceLoggingInterceptor {

    @Around("@annotation(logging)")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint, RequestLogging logging) throws Throwable {
        String clazzName = proceedingJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();
        Object response = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        if (logging.withResponse()) {
            log.info("[{}#{}]({}) return: {} response time: {} ms", clazzName, methodName, proceedingJoinPoint.getArgs(), response, costTime);
        }
        else {
            log.info("[{}#{}]({}) response time {} ms", clazzName, methodName, proceedingJoinPoint.getArgs(), costTime);
        }
        return response;
    }
}
