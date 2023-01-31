package com.example.recipesapi.contracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsernameDto {
    private Integer id;
    private String login;
    private String email;

}
