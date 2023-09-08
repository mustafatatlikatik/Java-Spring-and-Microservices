package com.mustafatatlikatik.bookseller.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false, length = 100)
    private String title;
    @Column(name = "description",nullable = false,length = 100)
    private String description;
    @Column(name = "author",nullable = false,length = 100)
    private String autor;
    @Column(name = "price",nullable = false)
    private Double price;
    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;
}
