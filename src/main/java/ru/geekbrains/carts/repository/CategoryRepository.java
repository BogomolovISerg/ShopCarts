package ru.geekbrains.carts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.carts.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    Category getByName(String name);
}


