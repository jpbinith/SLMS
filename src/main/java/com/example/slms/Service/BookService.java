package com.example.slms.Service;

import com.example.slms.Entity.Book;

import java.util.List;

public interface BookService {

    Book findByBookName(String bookName);
    Book findById(long id);
    List<Book> findAllBooks();

    List<Book> findAllAvailableBooks(boolean isAvailable);
    boolean isAvailable(long id);

    Book addBook(Book book);
    boolean deleteBook(long id);
    Book updateBook(long id, Book book);

}
