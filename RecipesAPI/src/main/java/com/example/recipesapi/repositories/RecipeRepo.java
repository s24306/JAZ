package com.example.recipesapi.repositories;

import com.example.recipesapi.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Integer> {
    Optional<List<Recipe>> findRecipeByName(String name);
}
