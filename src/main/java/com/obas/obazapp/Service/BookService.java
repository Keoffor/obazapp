package com.obas.obazapp.Service;

import com.obas.obazapp.Repository.BookRepo;
import com.obas.obazapp.Repository.UserRepo;
import com.obas.obazapp.model.AddBook;
import com.obas.obazapp.model.Book;
import com.obas.obazapp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepo bookRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> AllBooks(){
        List<Book> getAll  = bookRepo.findAll();
        return getAll;

    }

    public Book addBook(AddBook addBook) throws Exception{
        Users checkEmail = userRepo.findByEmail(addBook.getUserEMail());
        Book book = new Book();
        if(checkEmail==null){
            throw new Exception();

        }else {

            book.setBooktitle(addBook.getBooktitle());
            book.setAuthor(addBook.getAuthor());
            book.setRating(addBook.getRating());
            book.setUsers(checkEmail);
            bookRepo.save(book);
        }
        return book;

    }
    public Book updateBook(AddBook updateBook) throws Exception {
        Users checkEmail = userRepo.findByEmail(updateBook.getUserEMail());
        Book book = new Book();
        if(checkEmail==null){
            throw new Exception();

        }else {

            book.setBooktitle(updateBook.getBooktitle());
            book.setAuthor(updateBook.getAuthor());
            book.setRating(updateBook.getRating());
            book.setUsers(checkEmail);
            bookRepo.save(book);
        }
        return book;
    }


}
