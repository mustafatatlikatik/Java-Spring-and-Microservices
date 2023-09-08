package com.mustafatatlikatik.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "plate", unique = true) // plaka
    private String plate;

    @Column(name = "dailyPrice") // günlük ücret
    private double dailyPrice;

    @Column(name = "modelYear") // kaç model
    private int modelYear;

    @Column(name = "state") // aracın durumu
    private int state; // 1=Available 2=Rented 3=Maintenance

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;


}
