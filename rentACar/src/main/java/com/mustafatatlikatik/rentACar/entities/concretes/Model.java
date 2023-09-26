package com.mustafatatlikatik.rentACar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Table(name = "models")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @OneToMany(mappedBy = "model")
    @JsonIgnore
    private List<Car> cars;
}
