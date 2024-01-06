package com.example.cms.controller;

import com.example.cms.controller.dto.WishlistDto;
import com.example.cms.controller.exceptions.ShoeNotFoundException;
import com.example.cms.controller.exceptions.UserNotFoundException;
import com.example.cms.model.entity.*;
import com.example.cms.model.repository.WishlistRepository;
import com.example.cms.model.repository.ShoeRepository;
import com.example.cms.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController

public class WishlistController {
    @Autowired
    private final WishlistRepository repository;


    @Autowired
    private ShoeRepository shoeRepository;

    @Autowired
    private UserRepository userRepository;

    public WishlistController(WishlistRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/wishlists")
    List<Wishlist> retrieveAllWishlists() {return repository.findAll(); }

    @GetMapping("/wishlists/{username}")
    List<Wishlist> retrieveWishlist( @PathVariable ( "username" ) String userName) {return repository.getWishlist(userName); }

    @DeleteMapping ( "/wishlists/{userName}/{shoeId}" )
    void deleteShoefromWishlist ( @PathVariable ( "userName" ) String userName ,
                        @PathVariable ( "shoeId" ) long shoeId ) {
        WishlistKey key = new WishlistKey() ;
        key.setShoeId(shoeId);
        key.setUserName(userName);
        repository.deleteById(key);
    }

    @PostMapping("/wishlists")
    Wishlist createWishlist (@RequestBody WishlistDto wishlistDto) {

        Wishlist newWishlist = new Wishlist();

        WishlistKey key = new WishlistKey();
        key.setShoeId(wishlistDto.getShoeId());
        key.setUserName(wishlistDto.getUserId());

        newWishlist.setShoeWishId(key);

        Shoe shoe = shoeRepository.findById(wishlistDto.getShoeId()).orElseThrow(
                () -> new ShoeNotFoundException(wishlistDto.getShoeId()));

        User user = userRepository.findById(wishlistDto.getUserId()).orElseThrow(
                () -> new UserNotFoundException(wishlistDto.getUserId()));

        newWishlist.setShoe(shoe);
        newWishlist.setUser(user);

        return repository.save(newWishlist);
    }
}

