package com.project.java.controller;

import com.project.java.entity.Category;
import com.project.java.entity.Product;
import com.project.java.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/create")
    public String showCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "createCategory";
    }
    @GetMapping("/get")
    public String getALL(Model model){
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories",categories);
        return "categories";
    }

    @GetMapping("/getCategories")
    public List<Category> getCategories(){
        List<Category> categories = categoryService.getAllCategory();
        return categories;
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute("category") Category category){
        categoryService.saveCategory(category);
        return "redirect:/category/get";
    }
}
