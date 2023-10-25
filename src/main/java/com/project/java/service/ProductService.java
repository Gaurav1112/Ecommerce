package com.project.java.service;

import com.project.java.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public Product createProduct(Product product);
    public List<Product> getProductByCategoryName(String categoryName);
}
