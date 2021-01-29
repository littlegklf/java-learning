package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author kuanglifang
 * @date 2020/12/22 10:28
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut(value = "@annotation(com.example.demo.annotation.LogAnnotation)")
    public void webLog() {
    }

    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("URL：" + request.getRequestURL().toString());
        log.info("HTTP_METHOD：" + request.getMethod());
        log.info("IP：" + request.getRemoteAddr());
        log.info("CLASS_METHOD：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS：" + Arrays.toString(joinPoint.getArgs()));
        request.getRequestURL();
    }

    @AfterReturning(pointcut = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) {
        log.info("RESPONSE：" + ret);
    }
}
