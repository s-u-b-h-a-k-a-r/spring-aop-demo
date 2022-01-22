package com.subhakar.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    @Pointcut("within(com.subhakar.spring.factory..*)")
    public void authenticatePointCut() {
    }

    @Pointcut("within(com.subhakar.spring.factory..*)")
    public void authorizePointCut() {
    }

    @Before("authenticatePointCut() && authorizePointCut()")
    public void authenticate() {
        System.out.println("Authenticated !!!!");
    }
}
