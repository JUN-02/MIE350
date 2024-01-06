package com.example.cms.controller.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RatingDto {
    private long ratingId;
    private float ratingScore;
    private String description;
    private long shoeId;
    private String userName;

}
