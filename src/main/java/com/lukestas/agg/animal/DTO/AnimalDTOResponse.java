package com.lukestas.agg.animal.DTO;

import java.time.LocalDateTime;

import com.lukestas.agg.category.DTO.CategoryDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnimalDTOResponse(
        Integer animalId,

        @NotBlank(message = "Category is required") CategoryDTO category,

        LocalDateTime createdAt,

        LocalDateTime updatedAt,

        String description,

        String diet,

        String imageUrl,

        @NotNull(message = "Extinction Status is required") Boolean isExtinct,

        @NotBlank(message = "Popular name is required") String popularName,

        @NotBlank(message = "Scientific name is quired") String scientificName) {

}
