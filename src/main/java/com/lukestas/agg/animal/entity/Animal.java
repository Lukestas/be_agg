package com.lukestas.agg.animal.entity;

import java.time.LocalDateTime;

import com.lukestas.agg.category.entity.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Animal {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "animal_id")
        private Integer animalId;

        @Column(name = "scientific_name", nullable = false, unique = true, columnDefinition = "TEXT")
        private String scientificName;

        @Column(name = "popular_name", columnDefinition = "TEXT")
        private String popularName;

        @ManyToOne
        @JoinColumn(name = "category_id", nullable = false)
        private Category category;

        @Column(name = "description", columnDefinition = "TEXT")
        private String description;

        @Column(name = "diet", columnDefinition = "TEXT")
        private String diet;

        @Column(name = "image_url", columnDefinition = "TEXT")
        private String imageUrl;

        @Column(name = "is_extinct", nullable = false)
        private Boolean isExtinct;

        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @Column(name = "updated_at")
        private LocalDateTime updatedAt;

        public Integer getAnimalId() {
                return animalId;
        }

        public String getScientificName() {
                return scientificName;
        }

        public void setScientificName(String scientificName) {
                this.scientificName = scientificName;
        }

        public String getPopularName() {
                return popularName;
        }

        public void setPopularName(String popularName) {
                this.popularName = popularName;
        }

        public Category getCategory() {
                return category;
        }

        public void setCategory(Category category) {
                this.category = category;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getDiet() {
                return diet;
        }

        public void setDiet(String diet) {
                this.diet = diet;
        }

        public String getImageUrl() {
                return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
        }

        public Boolean getIsExtinct() {
                return isExtinct;
        }

        public void setIsExtinct(Boolean isExtinct) {
                this.isExtinct = isExtinct;
        }

        public LocalDateTime getCreatedAt() {
                return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
                this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
                return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
                this.updatedAt = updatedAt;
        }

}
