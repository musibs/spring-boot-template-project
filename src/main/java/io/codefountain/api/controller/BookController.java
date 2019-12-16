package io.codefountain.api.controller;

import io.codefountain.api.domain.Book;
import io.codefountain.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> getBooks(){
        return bookRepository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable("bookId") Long bookId){
        return bookRepository.findById(bookId).orElseThrow(RuntimeException::new);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId){
        bookRepository.deleteById(bookId);
    }
}