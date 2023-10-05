package com.lukesportfolio.bookgallery.service;

import com.lukesportfolio.bookgallery.model.Book;

import java.util.List;

public interface BookService {
    public Book addBook(Book book);
    public List<Book> getAllBooks();
    public List<Book> getBestsellers();
    public Book getBookById(Integer id);

    public List<Book> findByBookNameContaining(String name);

    public List<Book> findByBookTag(String tag);

    public void deleteBookById(Integer id);

    public void addBookDownloadsNum(Integer id);
}
