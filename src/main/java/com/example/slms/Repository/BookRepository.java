package com.example.slms.Repository;

import com.example.slms.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByBookName(String bookName);

    @Query(value = "SELECT * FROM `books` WHERE availability = true", nativeQuery = true)
    List<Book> findAllAvailableBooks(@Param("availability") boolean isAvailable);
}
