package com.lukesportfolio.bookgallery.controller;

import com.lukesportfolio.bookgallery.model.Book;
import com.lukesportfolio.bookgallery.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        try {
            bookService.addBook(book);
            return new ResponseEntity<String>("Upload successfully.", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Upload failure.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/incrementDownloads/{id}")
    public ResponseEntity<String> incrementDownloads(@PathVariable Integer id) {
        try {
            bookService.addBookDownloadsNum(id);
            return new ResponseEntity<String>("Downloads incremented successfully.", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>("Book not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error incrementing downloads.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getBestsellers")
    public List<Book> getgetBestsellersBestsellers(){
        return bookService.getBestsellers();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id){
        try {
            Book book = bookService.getBookById(id);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/findByBookName/{name}")
    public List<Book> findByBookNameContaining(@PathVariable String name){
        return bookService.findByBookNameContaining(name);
    }

    @GetMapping("/findByBookTag/{tag}")
    public List<Book> findByBookTag(@PathVariable String tag){
        return bookService.findByBookTag(tag);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateBookById(@RequestBody Book book, @PathVariable Integer id){
        try {
            Book existingBook = bookService.getBookById(id);
            book.setId(existingBook.getId());

            if (book.getAuthor() == null) {
                book.setAuthor(existingBook.getAuthor());
            }
            if (book.getContent() == null) {
                book.setContent(existingBook.getContent());
            }
            if (book.getCover() == null) {
                book.setCover(existingBook.getCover());
            }
            if (book.getDownloads() == 0) {
                book.setDownloads(existingBook.getDownloads());
            }
            if (book.getIntro() == null) {
                book.setIntro(existingBook.getIntro());
            }
            if (book.getName() == null) {
                book.setName(existingBook.getName());
            }
            if (book.getPrice() == 0.0) {
                book.setPrice(existingBook.getPrice());
            }
            if (book.getTag() == null) {
                book.setTag(existingBook.getTag());
            }

            bookService.addBook(book);
            return new ResponseEntity<String>("Update successfully.", HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<String>("Update failure.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Book> delete(@PathVariable Integer id){
        try {
            Book existingBook = bookService.getBookById(id);
            bookService.deleteBookById(id);
            return new ResponseEntity<Book>(existingBook, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }
}
