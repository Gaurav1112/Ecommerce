package com.project.java.service;

import com.project.java.entity.Category;

import java.util.List;


public interface CategoryService {
    public Category saveCategory(Category category);
    public List<Category> getAllCategory();
}
