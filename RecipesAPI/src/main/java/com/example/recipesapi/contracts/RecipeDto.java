package com.example.recipesapi.contracts;

import com.example.recipesapi.models.Rating;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
    private Integer id;
    private String name;
    private String description;
    private int rating;

}
