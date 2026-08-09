package com.lukestas.agg.animal.controller;

import org.springframework.web.bind.annotation.RestController;

import com.lukestas.agg.animal.DTO.AnimalDTOResponse;
import com.lukestas.agg.animal.entity.Animal;
import com.lukestas.agg.animal.service.AnimalService;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public ResponseEntity<?> createAnimal(@RequestBody Animal animal) {
        Animal newAnimal = animalService.saveNewAnimal(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAnimal);
    }

    @GetMapping
    public ResponseEntity<Page<AnimalDTOResponse>> getAllAnimals(
            @RequestParam(required = false) Boolean isExtinct,
            @RequestParam(required = false) String popularName,
            @RequestParam(required = false) String scientificName,
            @RequestParam(required = false) Integer category,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer totalPerPage) {
        Page<AnimalDTOResponse> animalsFound = animalService.getAllAnimals(isExtinct, popularName, scientificName,
                category, page,
                totalPerPage);

        return ResponseEntity.ok(animalsFound);
    }

    @GetMapping("/{animalId}")
    public ResponseEntity<?> getAnimalById(@PathVariable Integer animalId) {
        Optional<AnimalDTOResponse> animalFound = animalService.getByAnimalId(animalId);
        return animalFound.isPresent() ? ResponseEntity.ok(animalFound.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal no encontrado");
    }

    @PutMapping("/{animalId}")
    public ResponseEntity<?> updateAnimal(@PathVariable Integer animalId, @RequestBody Animal animal) {
        return ResponseEntity.ok(animalService.updateAnimal(animalId, animal));
    }

    @DeleteMapping("/{animalId}")
    public ResponseEntity<?> deleteAnimal(@PathVariable Integer animalId) {
        try {
            animalService.deleteAnimal(animalId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
