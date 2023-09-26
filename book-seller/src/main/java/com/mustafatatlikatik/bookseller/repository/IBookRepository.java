package com.mustafatatlikatik.bookseller.repository;

import com.mustafatatlikatik.bookseller.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {

}
