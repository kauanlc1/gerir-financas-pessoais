package org.example.Exceptions;

public class CategoryExistingException extends RuntimeException {
    public CategoryExistingException(String message) {
        super(message);
    }
}
