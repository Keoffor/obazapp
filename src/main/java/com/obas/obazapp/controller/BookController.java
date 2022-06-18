package com.obas.obazapp.controller;

import com.obas.obazapp.Service.BookService;
import com.obas.obazapp.model.AddBook;
import com.obas.obazapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<Book>>allBooks(){
        List<Book> book = bookService.AllBooks();
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody AddBook addBook){
        try {
            Book book = bookService.addBook(addBook);
            return ResponseEntity.status(HttpStatus.OK).body("Added successfully");
        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("email does not exist");
        }

    }

    @PutMapping("/update")
    public ResponseEntity updateBook(@RequestBody AddBook addBook){
        try {
            Book book = bookService.addBook(addBook);
            return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("email does not exist");
        }
    }
}
