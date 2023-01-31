package com.example.recipesapi.contracts;

import com.example.recipesapi.models.Recipe;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    private Integer id;
    private String time;
}
