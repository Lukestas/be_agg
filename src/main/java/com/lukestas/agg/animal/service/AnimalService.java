package com.lukestas.agg.animal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lukestas.agg.animal.entity.Animal;

@Service
public interface AnimalService {

    /**
     * Add new animal in DataBase
     * 
     * @param animal
     * @return animal
     */

    Animal saveNewAnimal(Animal animal);

    /**
     * Search one or many animals
     * 
     * @return One or a list of animals
     */

    List<Animal> getAllAnimals();

    Optional<Animal> getByAnimalId(Integer animalId);

    /**
     * Update Animal data
     * 
     * @return new animal data
     */

    Animal updateAnimal(Integer animalId, Animal animal);

    /**
     * Delete Animal
     */

    void deleteAnimal(Integer animalId);

}
