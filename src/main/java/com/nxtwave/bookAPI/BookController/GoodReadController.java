package com.nxtwave.bookAPI.BookController;

import com.nxtwave.bookAPI.Book.Book;
import com.nxtwave.bookAPI.BookService.BookServiceClass;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class GoodReadController {
    BookServiceClass bs = new BookServiceClass();
    @GetMapping("/books")
    public ArrayList<Book> getBooks(){
        return bs.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId){
        return bs.getBookById(bookId);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return bs.addBook(book);
    }

    @PutMapping("/books/{bookid}")
    public Book updateBook(@PathVariable("bookid") int bookId, @RequestBody Book book){
        return bs.updateBook(bookId, book);
    }

    @DeleteMapping("/books/{bookid}")
    public void deleteBook(@PathVariable("bookid") int bookId){
        bs.deleteBook(bookId);
    }
}
