package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // Tells Spring Boot this class handles web traffic
@RequestMapping("/books") // All URLs in this file will start with /books
public class LibraryController {

    private final LibraryService libraryService;

    // Connect the Controller to our Service (the brain)
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    // --- 1. READ: Show all books ---
    // When the user goes to http://localhost:8080/books
    @GetMapping
    public String listBooks(Model model) {
        // Fetch all books from the database
        model.addAttribute("books", libraryService.getAllBooks());
        // Tell Spring to show the "list-books.jsp" web page
        return "list-books"; 
    }

    // --- 2. CREATE: Show the empty form ---
    // When the user clicks "Add New Book"
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book()); // Send an empty book object
        model.addAttribute("authors", libraryService.getAllAuthors()); // For the dropdown menu
        return "book-form"; // Tell Spring to show the "book-form.jsp" page
    }

    // --- 3. CREATE / UPDATE: Save the data ---
    // When the user clicks the "Submit" button on the form
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        try {
            libraryService.saveBook(book); // Save to database
        } catch (Exception e) {
            // If something goes wrong, send them back to the list with an error message
            return "redirect:/books?error=DataIntegrityViolation";
        }
        return "redirect:/books"; // On success, redirect back to the book list
    }

    // --- 4. UPDATE: Show the pre-filled form ---
    // When the user clicks "Edit" next to a specific book
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        // Find the specific book and send it to the form
        model.addAttribute("book", libraryService.getBookById(id));
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "book-form";
    }
}