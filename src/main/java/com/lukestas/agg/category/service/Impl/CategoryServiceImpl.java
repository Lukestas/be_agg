package com.lukestas.agg.category.service.Impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lukestas.agg.category.entity.Category;
import com.lukestas.agg.category.repository.CategoryRepository;
import com.lukestas.agg.category.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveNewCategory(Category category) {
        LocalDateTime now = LocalDateTime.now();
        category.setCreatedAt(now);
        category.setUpdatedAt(now);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Category updateCategory(Integer categoryId, Category category) {
        Category categoryFound = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category ID " + categoryId + " not found"));

        categoryFound.setCategoryName(category.getCategoryName());
        categoryFound.setUpdatedAt(LocalDateTime.now());

        Category categoryUpdated = categoryRepository.save(categoryFound);
        return categoryUpdated;

    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category categoryFound = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category ID " + categoryId + " not found"));
        categoryRepository.deleteById(categoryFound.getCategoryId());
    }

}
