package com.example.recipesapi.services;

import com.example.recipesapi.Messages.ErrorMessages;
import com.example.recipesapi.Messages.SuccessMessages;
import com.example.recipesapi.contracts.RecipeDto;
import com.example.recipesapi.contracts.UsernameDto;
import com.example.recipesapi.models.Rating;
import com.example.recipesapi.models.Recipe;
import com.example.recipesapi.models.Username;
import com.example.recipesapi.repositories.RecipeRepo;
import com.example.recipesapi.repositories.RatingRepo;
import com.example.recipesapi.repositories.UserRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Getter
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private RecipeRepo recipeRepository;
    @Autowired
    private RatingRepo servingRepo;

    public List<UsernameDto> getAll() {
        List<UsernameDto> usernameDtoList = new ArrayList<>();
        for (Username username : userRepository.findAll()) {
            usernameDtoList.add(new UsernameDto(username.getId(), username.getLogin(), username.getEmail()));
        }
        return usernameDtoList;
    }

    public List<RecipeDto> getAllRecipes() {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        for (Recipe recipe : recipeRepository.findAll()) {
            recipeDtoList.add(new RecipeDto(recipe.getId(), recipe.getName(), recipe.getDescription(), recipe.getRating().getRating()));
        }
        return recipeDtoList;
    }

    public ResponseEntity<String> save(UsernameDto usernameDto) {
        ResponseEntity response;
        List<Username> user = userRepository.findAll().stream()
                .filter(s -> s.getId().equals(usernameDto.getId())).collect(Collectors.toList());
        if (user.size() != 0) {
            response = new ResponseEntity(Map.of("error: ", ErrorMessages.ID_EXISTS.toString()), HttpStatus.BAD_REQUEST);
        } else {
            userRepository.save(new Username(usernameDto.getId(), usernameDto.getLogin(), usernameDto.getEmail()));
            response = new ResponseEntity(Map.of("succes:", SuccessMessages.SAVE_SUCCESS.toString()), HttpStatus.OK);
        }
        return response;
    }

    public void update(UsernameDto usernameDto) {
        var user = userRepository.findById(usernameDto.getId()).orElse(null);
        if (user != null) {
            user.setLogin(usernameDto.getLogin());
            user.setEmail(usernameDto.getEmail());
            userRepository.save(user);
        }
    }

    public void deleteUser(int userId) {
        userRepository.findById(userId).ifPresent(person -> userRepository.deleteById(userId));
    }

    public void deleteRecipe(int userId, int recipeId) {
        var user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            List<Recipe> recipes = user.getRecipes().stream().filter(
                    s -> s.getId() != recipeId).collect(Collectors.toList());
            user.setRecipes(recipes);
            userRepository.save(user);
            recipeRepository.findById(recipeId).ifPresent(recipe -> recipeRepository.deleteById(recipeId));
        }
    }


    public void addRecipe(int userId, RecipeDto recipeDto) {
        var user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            Rating rating = new Rating(recipeDto.getRating());
            var recipe = new Recipe(recipeDto.getId(), recipeDto.getName(), recipeDto.getDescription());
            recipe.setUsername(user);
            recipe.setRating(rating);
            user.getRecipes().add(recipe);
            recipeRepository.save(recipe);
            userRepository.save(user);
        }
    }

    public List<RecipeDto> getRecipes(int userId) {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        var user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            List<Recipe> recipes = user.getRecipes();
            for (Recipe recipe : recipes) {
                recipeDtoList.add(new RecipeDto(recipe.getId(), recipe.getName(), recipe.getDescription(), recipe.getRating().getRating()));
            }
        }
        return recipeDtoList;
    }

}
