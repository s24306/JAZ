package com.example.recipesapi.repositories;

import com.example.recipesapi.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer> {
}
