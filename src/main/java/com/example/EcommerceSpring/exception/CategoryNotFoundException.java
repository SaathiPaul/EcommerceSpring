package com.example.EcommerceSpring.exception;

public class CategoryNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }

}
