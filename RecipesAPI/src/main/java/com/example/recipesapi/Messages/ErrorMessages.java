package com.example.recipesapi.Messages;

public enum ErrorMessages {

    OUT_OF_BOUNDS("The id is out of bounds!"),
    ID_EXISTS("User exists with this ID!");

    String error;

    ErrorMessages(String error) {
            this.error = error;
    }

    @Override
    public String toString() {
        return this.error;
    }
}