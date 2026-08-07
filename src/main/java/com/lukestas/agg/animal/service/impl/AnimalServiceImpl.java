package com.lukestas.agg.animal.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lukestas.agg.animal.entity.Animal;
import com.lukestas.agg.animal.repository.AnimalRepository;
import com.lukestas.agg.animal.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

    private AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal saveNewAnimal(Animal animal) {
        LocalDateTime now = LocalDateTime.now();

        animal.setCreatedAt(now);
        animal.setUpdatedAt(now);

        return animalRepository.save(animal);
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll(Sort.by(Sort.Direction.DESC, "popularName"));
    }

    @Override
    public Optional<Animal> getByAnimalId(Integer animalId) {
        return animalRepository.findById(animalId);
    }

    @Override
    public Animal updateAnimal(Integer animalId, Animal animal) {
        Animal animalFound = animalRepository.findById(animalId)
                .orElseThrow(() -> new RuntimeException("Animal ID " + animalId + " not found"));

        animalFound.setCategoryId(animal.getCategoryId());
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
