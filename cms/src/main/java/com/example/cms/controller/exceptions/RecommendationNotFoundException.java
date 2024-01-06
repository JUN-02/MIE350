package com.example.cms.controller.exceptions;

public class RecommendationNotFoundException extends RuntimeException{
    public RecommendationNotFoundException(Long recommendationId) {
        super("Could not find recommendation"+recommendationId);
    }
}
