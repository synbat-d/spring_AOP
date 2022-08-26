package com.world;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Library lib = context.getBean("library", Library.class);
        Book book1 = context.getBean("book", Book.class);
        Book book2 = lib.getBook("Symbat Dulatuly", book1);
        System.out.println(book2);
        String anime = lib.addBook();
        System.out.println(anime);
        context.close();

    }
}
