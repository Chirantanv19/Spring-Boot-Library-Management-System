package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.LibraryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {

    @Mock // This creates a "fake" repository so we don't accidentally mess with our real database
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks // This injects the fake repositories into our real service
    private LibraryService libraryService;

    @Test
    public void testGetAllBooks() {
        // 1. Arrange (Set up the fake data)
        Book fakeBook = new Book();
        fakeBook.setTitle("Test Book");
        
        // Tell the fake repository: "When someone asks for all books, return this list of 1 fake book"
        when(bookRepository.findAllBooksWithAuthors()).thenReturn(Arrays.asList(fakeBook));

        // 2. Act (Actually test our service method)
        List<Book> result = libraryService.getAllBooks();

        // 3. Assert (Check if the result matches what we expect)
        assertEquals(1, result.size());
        assertEquals("Test Book", result.get(0).getTitle());
        
        // Verify that the service actually called the custom inner join query!
        verify(bookRepository, times(1)).findAllBooksWithAuthors();
    }

    @Test
    public void testSaveBook() {
        Book newBook = new Book();
        newBook.setTitle("New Database Book");

        when(bookRepository.save(newBook)).thenReturn(newBook);

        Book savedBook = libraryService.saveBook(newBook);

        assertNotNull(savedBook);
        assertEquals("New Database Book", savedBook.getTitle());
        verify(bookRepository, times(1)).save(newBook);
    }
}