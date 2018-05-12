package com.gj1913894.web.starter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAop {
    @Pointcut("execution(* com.gj1913894.web.starter.service.UserService.*(..))")
    public void executeService() {
    }

    @Around("executeService()")
    public void invoke(ProceedingJoinPoint joinPoint) {
        System.out.println("before");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after");
    }
}
