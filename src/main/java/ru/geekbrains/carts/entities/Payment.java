package ru.geekbrains.carts.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Integer id;
    private BigDecimal amount;

    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }

    public BigDecimal getAmount(){
        return amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }
}
