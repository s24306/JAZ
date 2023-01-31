package com.example.recipesapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    private Integer id;
    private String name;
    private String description;

    @ManyToOne
    private Username username;

    @ManyToOne
    private Rating rating;

    public Recipe(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
