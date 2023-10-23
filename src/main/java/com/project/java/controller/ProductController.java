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
    @GetMapping("/create")
    public String showCreateProductForm(Model model){
        model.addAttribute("product", new Product());
        return "createProduct";
    }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute("product") Product product){

        productService.createProduct(product);
        return "redirect:/product/get";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product",product);
        return "productDescription";
    }
}
