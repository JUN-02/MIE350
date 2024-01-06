package com.example.cms.controller;

import com.example.cms.controller.dto.RatingDto;
import com.example.cms.controller.exceptions.ShoeNotFoundException;
import com.example.cms.controller.exceptions.UserNotFoundException;
import com.example.cms.model.entity.Rating;
import com.example.cms.model.entity.Recommendation;
import com.example.cms.model.entity.User;
import com.example.cms.model.repository.*;
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
public class RecommendationController {
    @Autowired
    private final RecommendationRepository repository;

    public RecommendationController(RecommendationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/recommendations")
    List<Recommendation> retrieveAllRecommendations() {return repository.findAll();}

  /*  @GetMapping("/recommendations/{recommendId}")
    List<Recommendation> retreiveRecommendation(@PathVariable("recommendId") Long recommendId) { return this.repository.findById(recommendationId);}

   */
}
