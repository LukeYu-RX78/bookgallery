package com.lukesportfolio.bookgallery.service;

import com.lukesportfolio.bookgallery.model.Book;
import com.lukesportfolio.bookgallery.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBestsellers() {
        return bookRepository.findBestSellers();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> findByBookNameContaining(String bookName) {
        return bookRepository.findByNameContaining(bookName);
    }

    @Override
    public List<Book> findByBookTag(String tag) {
        return bookRepository.findByTag(tag);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void addBookDownloadsNum(Integer id) {
        bookRepository.addBookDownloadsNum(id);
    }
}
