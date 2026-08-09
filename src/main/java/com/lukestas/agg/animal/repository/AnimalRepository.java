package com.lukestas.agg.animal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lukestas.agg.animal.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
  @Query("""
        SELECT a
      FROM Animal a
      WHERE (:isExtinct IS NULL OR a.isExtinct = :isExtinct)
      AND (:popularName IS NULL OR LOWER(a.popularName) LIKE LOWER(CONCAT('%', CAST(:popularName AS string), '%')))
      AND (:scientificName IS NULL OR LOWER(a.scientificName) LIKE LOWER(CONCAT('%', CAST(:scientificName AS string), '%')))
      AND (:category IS NULL OR a.category.categoryId = :category)
        """)
  Page<Animal> findAnimals(
      @Param("isExtinct") Boolean isExtinct,
      @Param("popularName") String popularName,
      @Param("scientificName") String scientificName,
      @Param("category") Integer category,
      Pageable pageable);
}
