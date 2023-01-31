package com.example.recipesapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name="\"USERNAME\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Username {

    @Id
    @Column(name = "username_id")
    private Integer id;
    private String login;
    private String email;

    @OneToMany(mappedBy = "id")
    private List<Recipe> recipes;

    public Username(Integer id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }
}
