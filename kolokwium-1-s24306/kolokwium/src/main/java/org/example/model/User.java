package main.java.org.example.model;

import main.java.org.example.model.annotations.init;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@init(method="initUser")
public class User implements IHaveRoles {
    private String username;
    private LocalDateTime lastSeen;
    private boolean isActive;

    private double rating;
    private Role role;

    public User() {
    }

    public User(String username, LocalDateTime lastSeen, boolean isActive, double rating) {
        this.username = username;
        this.lastSeen = lastSeen;
        this.isActive = isActive;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(LocalDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    @Override
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void initUser(){
        this.rating = 5;
    }

}
