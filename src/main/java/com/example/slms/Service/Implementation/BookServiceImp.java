package com.example.slms.Service.Implementation;

import com.example.slms.Entity.Book;
import com.example.slms.Exceptions.CustomException;
import com.example.slms.Repository.BookRepository;
import com.example.slms.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book){
        Optional<Book> optionalBook = bookRepository.findByBookName(book.getBookName());
        if(optionalBook.isPresent()){
            throw new CustomException(400, "Book already exist");
        }else return bookRepository.save(book);
    }

    @Transactional
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book findById(long id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new CustomException(400, "Book not found"));
    }

    public Book findByBookName(String bookName){
        Optional<Book> bookOptional = bookRepository.findByBookName(bookName);
        if (bookOptional.isPresent()){
            return bookOptional.get();
        }else throw new CustomException(400, "Book not found");
    }

    public List<Book> findAllAvailableBooks(boolean isAvailable){
        return bookRepository.findAllAvailableBooks(isAvailable);
    }

    public boolean isAvailable(long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get().isAvailable();
        }else throw new CustomException(400, "Book not found");

    }

    public boolean deleteBook(long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            bookRepository.deleteById(id);
            return true;
        }else return false;
    }

    public Book updateBook(long id, Book book){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            return bookRepository.save(book);
        }else throw new CustomException(400, "Book not found");
    }
}
