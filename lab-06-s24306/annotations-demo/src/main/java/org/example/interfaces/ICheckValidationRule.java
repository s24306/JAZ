package main.java.org.example.interfaces;

import main.java.org.example.validation.ValidationResult;

public interface ICheckValidationRule {
    <T> void validate(ValidationResult<T> validationResult) throws IllegalAccessException;
}
