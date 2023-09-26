package com.mustafatatlikatik.bookseller.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "purchase_history")
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id",nullable = false)
    private Long userId;
    @Column(name = "book_Id",nullable = false)
    private Long bookId;
    @Column(name = "price",nullable = false)
    private Double price;
    @Column(name = "purcahase_time",nullable = false)
    private LocalDateTime purchaseTime;
}
