package com.example.recipesapi.repositories;

import com.example.recipesapi.models.Username;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Username, Integer> {
    Optional<Username> findUserByLogin(String username);
    Optional<Username> findUserByEmail(String email);
}
