package com.lukestas.agg.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lukestas.agg.animal.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
