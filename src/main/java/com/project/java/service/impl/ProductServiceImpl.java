package com.project.java.service.impl;

import com.project.java.entity.Product;
import com.project.java.repository.ProductRepository;
import com.project.java.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Product product =productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product with Id " + id + "not found")
        );
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
