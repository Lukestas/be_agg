package com.lukestas.agg.category.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lukestas.agg.category.DTO.CategoryDTO;
import com.lukestas.agg.category.entity.Category;

@Service
public interface CategoryService {

    Category saveNewCategory(Category category);

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Integer categoryId);

    Category updateCategory(Integer categoryId, Category category);

    void deleteCategory(Integer categoryId);
}
