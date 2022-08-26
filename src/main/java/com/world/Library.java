package com.world;


import org.springframework.stereotype.Component;

@Component
public class Library {
    public Book getBook(String name, Book book){
        System.out.println("We get a book from librarian");
        System.out.println("-------------------------------------------------------------");
        return book;
    }

    public String addBook() {
        System.out.println("We add book to library");
        System.out.println("-------------------------------------------------------------");
        return "Naruto";
    }

}
