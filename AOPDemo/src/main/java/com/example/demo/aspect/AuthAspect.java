package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 权限校验
 *
 * @author kuanglifang
 * @date 2020/12/16 11:04
 */
@Aspect
@Component
public class AuthAspect {

    @Pointcut("execution(public * com.example.demo.controller.LoginController.auth())")
    public void logAspect() {
    }

    @Before("logAspect()")
    public void auth() {
        System.out.println("==============before通知");
    }

    @AfterReturning("execution(public * com.example.demo.controller.LoginController.auth())")
    public void afterReturning() {
        System.out.println("=========AfterReturning通知");
    }

    @Around(value = "logAspect()")
    public Object around(ProceedingJoinPoint proceed) throws Throwable {
        System.out.println("===========环绕通知1");
        Object result = proceed.proceed();
        System.out.println("===========环绕通知2");
        return result;
    }

    @After(value = "logAspect()")
    public void after() {
        System.out.println("============after通知");
    }
}
