package ru.geekbrains.carts.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="order_items")
@Getter
@Setter
public class OrderItem{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    private BigDecimal price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    public BigDecimal getSubTotal(){
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
