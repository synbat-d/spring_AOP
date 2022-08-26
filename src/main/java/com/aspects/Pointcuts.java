package com.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* com.world.Library.get*(..))")
    public void allGetMethods() {}

}
