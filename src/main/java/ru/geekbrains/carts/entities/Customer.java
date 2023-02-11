package ru.geekbrains.carts.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="customers")
@Getter
@Setter
public class Customer{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="firstname", nullable=false)

    @NotEmpty
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @NotEmpty
    @Email
    @Column(name="email", nullable=false, unique=true)
    private String email;

    @NotEmpty
    @Column(name="password", nullable=false)
    private String password;

    public String getEmail(){
        return email;
    }
}
