package com.mustafatatlikatik.bookseller.service;

import com.mustafatatlikatik.bookseller.model.Book;

import java.util.List;

public interface IBookService {
    Book saveBook(Book book);

    void deleteBook(Long id);

    List<Book> findAllBooks();
}
