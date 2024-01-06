package com.example.cms.controller;

import com.example.cms.controller.dto.RatingDto;
import com.example.cms.controller.dto.UserDto;
import com.example.cms.controller.exceptions.ShoeNotFoundException;
import com.example.cms.controller.exceptions.UserNotFoundException;
import com.example.cms.model.entity.Rating;
import com.example.cms.model.entity.User;
import com.example.cms.model.repository.RatingRepository;
import com.example.cms.model.repository.ShoeRepository;
import com.example.cms.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.cms.controller.dto.RatingDto;
import com.example.cms.controller.exceptions.ShoeNotFoundException;
import com.example.cms.model.entity.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController

public class RatingController {

    @Autowired
    private final RatingRepository repository;

    @Autowired
    private ShoeRepository shoeRepository;

    @Autowired
    private UserRepository userRepository;

    public RatingController(RatingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ratings/{shoeName}")
    List<Rating> retrieveShoeRatings(@PathVariable long shoeName) {
        return repository.findShoeRatings(shoeName);
    }

    @GetMapping("/ratings/{username}/{shoeId}")
    List<Rating> retrieveShoeRating(@PathVariable String username,@PathVariable Long shoeId) {
        return repository.findRating(username,shoeId);
    }
    @PostMapping("/ratings")
    Rating addShoeRating(@RequestBody RatingDto ratingDto) {
        Rating rating=new Rating();
        rating.setRatingId(ratingDto.getRatingId()+1);
        rating.setRatingScore(ratingDto.getRatingScore());
        Shoe shoe=shoeRepository.findById(ratingDto.getShoeId()).orElseThrow(
                () -> new ShoeNotFoundException(ratingDto.getShoeId()));
        User user=userRepository.findUser(ratingDto.getUserName());
                //.orElseThrow(() -> new UserNotFoundException(ratingDto.getUserName()));
        rating.setShoeId(shoe);
        rating.setUserName(user);
        rating.setDescription(ratingDto.getDescription());
        return repository.save(rating);
    }

    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@RequestBody RatingDto ratingDto, @PathVariable("ratingId") long ratingId) {
        return repository.findById(ratingId)
                .map(rating -> {
                    rating.setRatingScore(ratingDto.getRatingScore());
                    rating.setDescription(ratingDto.getDescription());
                    return repository.save(rating);
                })
                .orElseGet(() -> {
                    Rating newRating = new Rating();
                    newRating.setRatingId(ratingDto.getRatingId());
                    newRating.setUserName(userRepository.findUser(ratingDto.getUserName()));
                    newRating.setRatingScore(ratingDto.getRatingScore());
                    newRating.setDescription(ratingDto.getDescription());
                    newRating.setShoeId(shoeRepository.findShoe(ratingDto.getRatingId()));
                    return repository.save(newRating);
                });
    }


    @DeleteMapping("/ratings/{ratingId}")
    void removeShoeRating(@PathVariable("ratingId") long ratingId) {
        repository.deleteById(ratingId);
    }
}
