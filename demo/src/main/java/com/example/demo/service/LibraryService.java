package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // This tells Spring Boot: "This is the brain of the app!"
public class LibraryService {

    // We bring in our database messengers here
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    // Constructor to set them up
    public LibraryService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    // --- READ OPERATIONS ---
    
    public List<Book> getAllBooks() {
        // Here we use the custom Inner Join query we wrote earlier!
        return bookRepository.findAllBooksWithAuthors(); 
    }

    public List<Author> getAllAuthors() {
        // This is a built-in Spring command to get everything
        return authorRepository.findAll();
    }

    public Book getBookById(Long id) {
        // Try to find the book by its ID. If it doesn't exist, throw an error.
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    }

    // --- CREATE / UPDATE OPERATION ---
    
    public Book saveBook(Book book) {
        // The save() command is smart. 
        // If the book has no ID, it creates a new one. 
        // If the book has an ID, it updates the existing one!
        return bookRepository.save(book);
    }
}