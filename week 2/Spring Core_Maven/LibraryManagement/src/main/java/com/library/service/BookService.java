package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;

    // Exercise 2: Ensure that BookService class has a setter method for BookRepository.
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageLibrary() {
        System.out.println("BookService is managing the library...");
        if (bookRepository != null) {
            bookRepository.performTask();
            System.out.println("Dependency Injection successful!");
        } else {
            System.out.println("ERROR: BookRepository was NOT injected.");
        }
    }
}
