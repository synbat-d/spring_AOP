package com.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class SecurityAdvice {
    @Before("com.aspects.Pointcuts.allGetMethods()")
    public void beforeGetBookAdvice() {
        System.out.println("Secutiry work!!!@@@@@@@@@@@@@@");
    }
}
