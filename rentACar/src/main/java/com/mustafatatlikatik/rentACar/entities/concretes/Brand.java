package com.mustafatatlikatik.rentACar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Table(name = "brands")
@Getter //getter fonksiyonu
@Setter // setter fonksiyonu => getter ve setterları ortak olarak @Data ile de yazabilirdik
@AllArgsConstructor // tüm parametrelerden oluşan constructor
@NoArgsConstructor // parametresiz constructor
@Entity // veri tabanı varlığı olduğunu belirtiyor
public class Brand {

    @Id // sen primary key'e karşılık gelirsin
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id'yi otomatik olarak 1 arttırır
    @Column(name = "id") // sen veri tabanınındaki id kolonuna karşılık geleceksin
    private int id;    // eğer id ile veri tabanındaki isim uyuşmazsa Column yazılır

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Model> models;

}
//Brand => id,name,quantity
//GetAllBrandsResponse => id,name