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
public class Rating {

    @Id
    private Integer id;
    private int rating;

    @OneToMany(mappedBy = "id")
    private List<Recipe> recipes;

    public Rating(Integer id, int rating) {
        this.id = id;
        this.rating = rating;
    }
}
