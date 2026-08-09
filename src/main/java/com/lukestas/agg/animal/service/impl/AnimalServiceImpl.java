package com.lukestas.agg.animal.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lukestas.agg.animal.entity.Animal;
import com.lukestas.agg.animal.repository.AnimalRepository;
import com.lukestas.agg.animal.service.AnimalService;
import com.lukestas.agg.category.entity.Category;
import com.lukestas.agg.category.repository.CategoryRepository;

@Service
public class AnimalServiceImpl implements AnimalService {

    private AnimalRepository animalRepository;
    private CategoryRepository categoryRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository, CategoryRepository categoryRepository) {
        this.animalRepository = animalRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Animal saveNewAnimal(Animal animal) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(animal.getCategory());
        Category category = categoryRepository.findById(
                animal.getCategory().getCategoryId()).orElseThrow(
                        () -> new RuntimeException(
                                "Category ID " + animal.getCategory().getCategoryId() + " not found"));
        animal.setCreatedAt(now);
        animal.setUpdatedAt(now);
        animal.setCategory(category);

        return animalRepository.save(animal);
    }

    @Override
    public Page<Animal> getAllAnimals(Boolean isExtinct, String popularName, String scientificName, Integer category,
            Integer page, Integer totalPerPage) {
        Pageable pageable = PageRequest.of(
                page,
                totalPerPage,
                Sort.by("popularName").ascending());
        return animalRepository.findAnimals(isExtinct, popularName, scientificName, category, pageable);
    }

    @Override
    public Optional<Animal> getByAnimalId(Integer animalId) {
        return animalRepository.findById(animalId);
    }

    @Override
    public Animal updateAnimal(Integer animalId, Animal animal) {
        Animal animalFound = animalRepository.findById(animalId)
                .orElseThrow(() -> new RuntimeException("Animal ID " + animalId + " not found"));

        Category category = categoryRepository.findById(
                animal.getCategory().getCategoryId()).orElseThrow(
                        () -> new RuntimeException(
                                "Category ID " +
                                        animal.getCategory().getCategoryId() +
                                        " not found"));

        animalFound.setCategory(category);
        animalFound.setScientificName(animal.getScientificName());
        animalFound.setPopularName(animal.getPopularName());
        animalFound.setDescription(animal.getDescription());
        animalFound.setDiet(animal.getDiet());
        animalFound.setIsExtinct(animal.getIsExtinct());
        animalFound.setImageUrl(animal.getImageUrl());
        animalFound.setUpdatedAt(LocalDateTime.now());

        Animal animalUpdated = animalRepository.save(animalFound);
        return animalUpdated;
    }

    @Override
    public void deleteAnimal(Integer animalId) {
        Animal animalFound = animalRepository.findById(animalId)
                .orElseThrow(() -> new RuntimeException("Animal ID " + animalId + " not found"));

        animalRepository.deleteById(animalFound.getAnimalId());
    }

}
