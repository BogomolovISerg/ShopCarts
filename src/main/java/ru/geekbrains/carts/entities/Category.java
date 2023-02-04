package ru.geekbrains.carts.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;

import java.util.Set;

@Entity
@Table(name="categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(nullable=false, unique=true)
    @NotEmpty
    private String name;

    @Column(length=1024)
    private String description;

    @Column(name="disp_order")
    private Integer displayOrder;

    private boolean disabled;

    @OneToMany(mappedBy="category")
    private Set<Product> products;

    public String getName(){
        return name;
    }
}
