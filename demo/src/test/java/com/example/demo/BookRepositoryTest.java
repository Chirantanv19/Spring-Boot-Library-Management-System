package com.example.demo;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest // Uses the main application context we know works!
@Transactional  // Cleans up the database after the test runs
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testFindAllBooksWithAuthors() {
        // 1. Arrange
        Author author = new Author();
        author.setName("Test Author");
        author.setNationality("Test Nation");
        authorRepository.save(author);

        Book book = new Book();
        book.setTitle("Test Title");
        book.setGenre("Test Genre");
        book.setAuthor(author);
        bookRepository.save(book);

        // 2. Act 
        List<Book> books = bookRepository.findAllBooksWithAuthors();

        // 3. Assert (Check that we got books back and the Inner Join worked)
        assertTrue(books.size() > 0, "Books list should not be empty");
        
        // If the author is not null, it means your custom JOIN FETCH query was a success!
        assertTrue(books.get(0).getAuthor() != null, "The author data should be joined to the book");
    }
}