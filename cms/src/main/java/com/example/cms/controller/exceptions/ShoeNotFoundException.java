package com.example.cms.controller.exceptions;

public class ShoeNotFoundException extends RuntimeException{
    public ShoeNotFoundException(Long shoeId) {
        super("Could not find shoe"+shoeId);
    }
}
