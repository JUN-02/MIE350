package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "shoeWish")

public class Wishlist {
    @EmbeddedId
    WishlistKey shoeWishId;

    @ManyToOne
    @MapsId("shoeId")
    @JoinColumn(name = "shoeId")
    @JsonIgnoreProperties({"shoeWish"})
    private Shoe shoe;

    @ManyToOne
    @MapsId("userName")
    @JoinColumn(name = "userName")
    @JsonIgnoreProperties({"shoeWish"})
    private User user;

}
