package com.project.java.service.impl;

import com.project.java.entity.Category;
import com.project.java.entity.Product;
import com.project.java.repository.CategoryRepository;
import com.project.java.repository.ProductRepository;
import com.project.java.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
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

        if (product.getCategory()!=null && product.getCategory().getId()!=null){
            Category category = categoryRepository.findById(product.getCategory().getId()).orElse(null);
            if (category!=null){
                product.setCategory(category);
            } else {
                Category defaultCategory= new Category();
                category.setId(9999L);
                category.setName("Undefined Default");
                product.setCategory(category);
                categoryRepository.save(category);
            }
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductByCategoryName(String categoryName) {
        List<Product> products = productRepository.findByCategoryName(categoryName);
        return products;
    }


}
