package com.example.cms.controller;

import com.example.cms.model.entity.ShoeRecommendation;
import com.example.cms.model.entity.Wishlist;
import com.example.cms.model.repository.ShoeRecommendationRepository;
import com.example.cms.model.repository.ShoeRepository;
import com.example.cms.model.repository.UserRepository;
import com.example.cms.model.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController

public class ShoeRecommendationController {

    @Autowired
    private final ShoeRecommendationRepository repository;

    @Autowired
    private ShoeRepository shoeRepository;

    @Autowired
    private UserRepository userRepository;

    public ShoeRecommendationController(ShoeRecommendationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/shoerecs")
    List<ShoeRecommendation> retrieveAllShoeRecs() {return repository.findAll(); }

    @GetMapping("/shoerecs/{recommendationId}")
    List<ShoeRecommendation> retrieveWishlist( @PathVariable( "recommendationId" ) Long recommendationId) {return repository.getRecommendation(recommendationId); }


}
