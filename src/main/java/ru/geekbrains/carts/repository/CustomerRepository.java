package ru.geekbrains.carts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.carts.entities.Customer;
import ru.geekbrains.carts.entities.Order;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    Customer findByEmail(String email);
    @Query("select o from Order o where o.customer.email=?1")
    List<Order> getCustomerOrders(String email);
}
