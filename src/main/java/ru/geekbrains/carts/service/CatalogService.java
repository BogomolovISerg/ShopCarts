package ru.geekbrains.carts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.carts.repository.CategoryRepository;
import ru.geekbrains.carts.repository.ProductRepository;
import ru.geekbrains.carts.entities.Category;
import ru.geekbrains.carts.entities.Product;
import ru.geekbrains.carts.security.SCException;

import java.util.List;

@Service
@Transactional
public class CatalogService{
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

    public List<Category> getAllCategories(){

        return categoryRepository.findAll();
    }

    public List<Product> getAllProducts(){

        return productRepository.findAll();
    }

    public Category getCategoryByName(String name){
        return categoryRepository.getByName(name);
    }

    public Category getCategoryById(Integer id){
        return categoryRepository.findOne(id);
    }

    public Category createCategory(Category category){
        Category persistedCategory = getCategoryByName(category.getName());
        if(persistedCategory != null){
            throw new SCException("Категория "+category.getName()+" уже существует");
        }
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category){
        Category persistedCategory = getCategoryById(category.getId());
        if(persistedCategory == null){
            throw new SCException("Категория "+category.getId()+" не существует");
        }
        persistedCategory.setDescription(category.getDescription());
        persistedCategory.setDisplayOrder(category.getDisplayOrder());
        persistedCategory.setDisabled(category.isDisabled());
        return categoryRepository.save(persistedCategory);
    }

    public Product updateProduct(Product product){
        Product persistedProduct = getProductById(product.getId());
        if(persistedProduct == null){
            throw new SCException("Товар "+product.getId()+" не существует");
        }
        persistedProduct.setDescription(product.getDescription());
        persistedProduct.setPrice(product.getPrice());
        persistedProduct.setCategory(getCategoryById(product.getCategory().getId()));
        return productRepository.save(persistedProduct);
    }

    public Product getProductById(Integer id){
        return productRepository.findOne(id);
    }

    public Product getProductByPCode(String cod){
        return productRepository.findByCod(cod);
    }

    public Product createProduct(Product product){
        Product persistedProduct = getProductByPCode(product.getName());
        if(persistedProduct != null){
            throw new SCException("Код товара "+product.getCod()+" уже существует");
        }
        return productRepository.save(product);
    }

    public List<Product> searchProducts(String query){
        return productRepository.search("%"+query+"%");
    }
}
