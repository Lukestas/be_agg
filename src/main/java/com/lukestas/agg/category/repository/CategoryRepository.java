package com.lukestas.agg.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lukestas.agg.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
