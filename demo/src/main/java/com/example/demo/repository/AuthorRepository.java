package com.example.demo.repository; // Check that this matches your folder path

import com.example.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Just by extending JpaRepository, Spring Boot automatically gives us 
    // built-in commands like save(), findAll(), and deleteById()!
}