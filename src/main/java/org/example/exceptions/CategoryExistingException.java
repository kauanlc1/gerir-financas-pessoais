package org.example.exceptions;

public class CategoryExistingException extends RuntimeException {
    public CategoryExistingException(String message) {
        super(message);
    }
}
