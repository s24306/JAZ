package com.example.recipesapi.Messages;

public enum SuccessMessages {

    SAVE_SUCCESS("The user was successfully added to the DB!");

    String success;

    SuccessMessages(String success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return this.success;
    }
}
