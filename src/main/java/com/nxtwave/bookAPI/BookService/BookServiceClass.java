package com.nxtwave.bookAPI.BookService;

import com.nxtwave.bookAPI.Book.Book;
import com.nxtwave.bookAPI.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class BookServiceClass implements BookRepository {
    private HashMap<Integer, Book> hmap = new HashMap<>();
    private int uniqueId = 3;
    public BookServiceClass(){
        Book b1 = new Book(1,"Think and Grow Rich","thinkandgrowrich.jpeg");
        Book b2 = new Book(2,"Can't Hurt Me","canthurtme.jpeg");
        hmap.put(b1.getId(), b1);
        hmap.put(b2.getId(), b2);

    }

    @Override
    public ArrayList<Book> getBooks() {
        Collection<Book> bookCollection = hmap.values();
        ArrayList<Book> books = new ArrayList<>(bookCollection);
        return books;
    }

    @Override
    public Book getBookById(int bookId) {
        Book book = hmap.get(bookId);
        if(book==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return book;
    }

    @Override
    public Book addBook(Book book) {
        book.setId(uniqueId);
        hmap.put(uniqueId,book);
        uniqueId++;
        return hmap.get(uniqueId);
    }

    @Override
    public Book updateBook(int bookId, Book book) {
        Book existingBook = hmap.get(bookId);
        if(existingBook==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(book.getName()!=null){
            existingBook.setName(book.getName());
        }
        if(book.getImageUrl()!=null){
            existingBook.setImageUrl(book.getImageUrl());
        }
        return existingBook;
    }

    @Override
    public void deleteBook(int bookId) {
        Book book = hmap.get(bookId);
        if(book==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            hmap.remove(bookId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}

