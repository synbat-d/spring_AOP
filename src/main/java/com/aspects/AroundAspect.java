package com.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAspect {

    @Around("execution(* addBook())")
    public Object aroundMethod (ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around method started his job");

        Long a = System.currentTimeMillis();
        Object mir = pjp.proceed();
        mir = "Sasuke";
        Long b =  System.currentTimeMillis();

        System.out.println("Around method finished his job in " + (b-a) + " milliseconds");

        return mir;
    }
}
