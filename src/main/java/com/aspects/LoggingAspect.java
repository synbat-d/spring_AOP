package com.aspects;

import com.world.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

    @Before("com.aspects.Pointcuts.allGetMethods()")
    public void beforeGetBookAdvice(JoinPoint j) {
        MethodSignature ms = (MethodSignature) j.getSignature();
        System.out.println("method signature: " + ms.getMethod());
        System.out.println("method name: " + ms.getName());
        System.out.println("method return type: " + ms.getReturnType());

        if(ms.getName()=="getBook") {
            Object [] arguments = j.getArgs();

            for(Object o: arguments) {
                if(o instanceof String) {
                    System.out.println(o + " is getting book");
                }
                if(o instanceof Book) {
                    System.out.println("book name: "+ ((Book) o).getName());
                    System.out.println("book author: "+ ((Book) o).getAuthor());
                    System.out.println("book year: "+ ((Book) o).getYear());
                }
            }
        }
        System.out.println("Before Logging Advice work!!!");
    }

    @AfterReturning(pointcut = "com.aspects.Pointcuts.allGetMethods()", returning = "book")
    public void afterReturningMethod (Book book) {
        book.setName("Fluid Mechanics");
        book.setAuthor("Nicolas Cage");
        book.setYear(2005);
        System.out.println("after returning advice has done his job !");
    }

    @AfterThrowing(pointcut = "execution(* addBook())", throwing = "exception")
    public void afterThrowingAdvice (Throwable exception) {
        System.out.println("Here it is time to after throwing advice to do his work");
        System.out.println("There is an exception of type: " + exception);
    }
}
