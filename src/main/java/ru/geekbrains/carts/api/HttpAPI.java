package ru.geekbrains.carts.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.carts.entities.Product;
import ru.geekbrains.carts.service.CatalogService;
import ru.geekbrains.carts.service.CustomerService;
import ru.geekbrains.carts.entities.Customer;
import ru.geekbrains.carts.entities.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HttpAPI {

    final CatalogService catalogService;
    final CustomerService customerService;

    @Autowired
    public HttpAPI(CatalogService catalogService, CustomerService customerService) {
        this.catalogService = catalogService;
        this.customerService = customerService;
    }

    @GetMapping(value = "/products/{pCode}")
    public Product product(@PathVariable String pCode){
        Product product = catalogService.getProductByPCode(pCode);
        return product;
    }

    @GetMapping(value = "/allCategoriesNames")
    public ArrayList<String> allCategoriesNames(){
        List<Category> categories = catalogService.getAllCategories();
        ArrayList<String> result = new ArrayList<>();
        for (Category category : categories) {
            result.add(category.getName());
        }
        return result;
    }

    @GetMapping(value = "/allProductsNames")
    public List<Product>  allProductsNames(){
        return catalogService.getAllProducts();
    }

    @GetMapping(value = "/allProductsCodes")
    public ArrayList<String> allProductsCodes(){
        List<Product> products = catalogService.getAllProducts();
        ArrayList<String> result = new ArrayList<>();
        for (Product product : products) {
            result.add(product.getCod());
        }
        return result;
    }

    @GetMapping(value = "/allProductsNamesAndPrices")
    public HashMap<String, String> allProductsNamesAndPrices(){
        List<Product> products = catalogService.getAllProducts();
        HashMap<String, String> result = new HashMap<>();
        for (Product product : products){
            result.put(product.getName(), String.valueOf(product.getPrice()));
        }
        return result;
    }

    @GetMapping(value = "/allCustomersEmails")
    public ArrayList<String> allCustomersEmails(){
        List<Customer> customers = customerService.getAllCustomers();
        ArrayList<String> result = new ArrayList<>();
        for (Customer customer : customers){
            result.add(customer.getEmail());
        }
        return result;
    }
}
