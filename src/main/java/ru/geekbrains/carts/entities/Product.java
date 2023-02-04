package ru.geekbrains.carts.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(nullable=false, unique=true)
    private String cod;
    @Column(nullable=false)
    private String name;
    private String description;
    @Column(nullable=false)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name="cat_id")
    private Category category;

    public String getName(){
        return name;
    }

    public String getCod(){
        return cod;
    }
    public BigDecimal getPrice(){
        return price;
    }
}
