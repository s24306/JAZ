package com.example.recipesapi.Controllers;

import com.example.recipesapi.contracts.RecipeDto;
import com.example.recipesapi.contracts.UsernameDto;
import com.example.recipesapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "api/v1/user", method = RequestMethod.GET)
    public List<UsernameDto> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "api/v1/user", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody UsernameDto usernameDto) {
        return userService.save(usernameDto);
    }


    @RequestMapping(value = "api/v1/user/{id}", method = RequestMethod.GET)
    public UsernameDto getUser(@PathVariable Integer id) {
        return userService.getAll().stream()
                .filter(usernameDto -> usernameDto.getId().equals(id))
                .findAny().orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "user not found"));

    }


    @RequestMapping(value = "api/v1/user/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Integer id, @RequestBody UsernameDto newUsernameDto) {
        if (userService.getUserRepository().findById(id).isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, "user not found");
        } else {
            newUsernameDto.setId(id);
            userService.update(newUsernameDto);
        }
    }

    @RequestMapping(value = "api/v1/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer id) {
        if (userService.getUserRepository().findById(id).isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, "user not found");
        } else {
            userService.delete(id);
        }
    }

    @RequestMapping(value = "api/v1/user/{id}/recipes", method = RequestMethod.GET)
    public List<RecipeDto> getRecipe(@PathVariable Integer id) {
        var recipe = userService.getRecipes(id);
        if (recipe.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, "recipe not present");
        } else {
            return recipe;
        }

    }

    @RequestMapping(value = "api/v1/user/{id}/recipes", method = RequestMethod.POST)
    public void addRecipe(@PathVariable Integer id, @RequestBody RecipeDto recipeDto) {
        if (userService.getUserRepository().findById(id).isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, "user not found");
        } else {
            userService.addRecipe(id, recipeDto);
        }
    }
}
