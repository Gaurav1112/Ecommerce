package com.project.java.controller;

import com.project.java.service.ProductService;
import com.project.java.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public String getAllProducts(Model model){
        List<Product> products= productService.getAllProducts();
        model.addAttribute("products", products);
        return "list";
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product",product);
        return "productDescription";
    }
}
