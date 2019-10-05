package cn.pasteme.common.service;

import cn.pasteme.common.annotation.RequestLogging;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Ryan Lee
 * @date 2019/10/01 17:47
 */
@Slf4j
public class ServiceLoggingInterceptor {
    @Around("@annotation(logging)")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint, RequestLogging logging) throws Throwable {
        long startTime = System.currentTimeMillis();
        String clazzName = proceedingJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        List<Object> methodParameterValues = Lists.newArrayList(proceedingJoinPoint.getArgs());
        Object response = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        if (logging.withResponse()) {
            log.info("[{}:{}]({}) return: {} response time: {}ms", clazzName, methodName, methodParameterValues, response, costTime);
        }
        else {
            log.info("[{}:{}]({}) response time {}ms", clazzName, methodName, methodParameterValues, costTime);
        }
        return response;
    }
}
