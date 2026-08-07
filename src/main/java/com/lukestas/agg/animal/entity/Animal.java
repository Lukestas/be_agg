package com.lukestas.agg.animal.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Animal {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "animal_id")
        private Integer animalId;

        @Column(name = "scientific_name", nullable = false, unique = true)
        private String scientificName;

        @Column(name = "popular_name")
        private String popularName;

        @Column(name = "category_Id", nullable = false)
        private Integer categoryId;

        @Column(name = "description")
        private String description;

        @Column(name = "diet")
        private String diet;

        @Column(name = "image_url")
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

        public Integer getCategoryId() {
                return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
                this.categoryId = categoryId;
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
