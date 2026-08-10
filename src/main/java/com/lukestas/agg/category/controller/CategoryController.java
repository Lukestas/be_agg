package com.lukestas.agg.category.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukestas.agg.category.DTO.CategoryDTO;
import com.lukestas.agg.category.entity.Category;
import com.lukestas.agg.category.service.CategoryService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        Category newCategory = categoryService.saveNewCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer categoryId) {
        CategoryDTO category = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer categoryId, @RequestBody Category entity) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryId, entity));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId) {
        try {
            categoryService.deleteCategory(categoryId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
