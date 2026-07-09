package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    
    public static void main(String[] args) {
        // Exercise 1: Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Exercise 2: Test the configuration and Dependency Injection
        BookService bookService = (BookService) context.getBean("bookService");
        
        System.out.println("--- Starting Library Management Application ---");
        bookService.manageLibrary();
    }
}
