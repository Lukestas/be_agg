package com.lukestas.agg.category.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lukestas.agg.category.entity.Category;

@Service
public interface CategoryService {

    Category saveNewCategory(Category category);

    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Integer categoryId);

    Category updateCategory(Integer categoryId, Category category);

    void deleteCategory(Integer categoryId);
}
