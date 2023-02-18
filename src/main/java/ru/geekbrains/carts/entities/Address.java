package ru.geekbrains.carts.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="addresses")
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String  addressLine;
    private String  city;
    private String  country;
}
