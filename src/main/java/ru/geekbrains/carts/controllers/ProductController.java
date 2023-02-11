package ru.geekbrains.carts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.carts.service.CatalogService;
import ru.geekbrains.carts.entities.Product;

import java.util.List;

@Controller
public class ProductController extends SiteController{
    @Autowired
    private CatalogService catalogService;

    @Override protected String getHeaderTitle(){
        return "Product";
    }

    @RequestMapping("/products/{pCode}")
    public String product(@PathVariable String pCode, Model model){
        Product product = catalogService.getProductByPCode(pCode);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping("/products")
    public String searchProducts(@RequestParam(name="q", defaultValue="") String query, Model model){
        List<Product> products = catalogService.searchProducts(query);
        model.addAttribute("products", products);
        return "products";
    }
}
