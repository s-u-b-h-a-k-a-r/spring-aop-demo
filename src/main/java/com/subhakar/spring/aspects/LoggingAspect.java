package com.subhakar.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.subhakar.spring.factory.CartFactory.*(..))")
    public void before(JoinPoint jp) {
        System.out.println(jp.getSignature().getName() + " started !!!");
    }

    @After("execution(* com.subhakar.spring.factory.CartFactory.*(..))")
    public void after(JoinPoint jp) {
        System.out.println(jp.getSignature().getName() + " ended !!!");
    }
}
