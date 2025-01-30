package org.example.notes.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Around("@within(org.example.notes.logging.Loggable) || @annotation(org.example.notes.logging.Loggable)")
    public Object loggingAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        log.info("{} start witch args {}", method, Arrays.toString(args));
        try {
            Object result = joinPoint.proceed();
            log.info("{} finish with result [{}]", method, Arrays.toString(args));
            return result;
        } catch (Exception e){
            log.error(" {} fail with args {}", method, Arrays.toString(args));
            throw e;
        }
    }
}
