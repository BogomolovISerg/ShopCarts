package ru.geekbrains.carts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.carts.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    Product findByCod(String cod);
    @Query("select p from Product p where p.name like ?1 or p.cod like ?1")
    List<Product> search(String query);
}
