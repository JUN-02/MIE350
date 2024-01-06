package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "shoes")
public class Shoe {

    @Id
    @NotEmpty
    private Long shoeId;

    @NotEmpty
    private String shoeName;

    @NotEmpty
    private String color;

    @NotEmpty
    private String type;

    @NotEmpty
    private String gender;

    @NotEmpty
    private float price;

    @NotEmpty
    private float size;

    @NotEmpty
    private String brand;

    @Nullable
    private String image_url;

   // @OneToMany(mappedBy = "shoe")
   // @Nullable
   // private List<Wishlist> wishlist = new ArrayList<>();


    public Shoe(Long shoeId, String shoeName, float size,String brand, String gender,String color,float price, String type){
        this.shoeId=shoeId;
        this.shoeName=shoeName;
        this.color=color;
        this.type=type;
        this.gender=gender;
        this.price=price;
        this.brand=brand;
        this.size=size;
    }

    public Shoe(Long shoeId, String shoeName, float size,String brand, String gender,String color,float price, String type, String image_url){
        this.shoeId=shoeId;
        this.shoeName=shoeName;
        this.color=color;
        this.type=type;
        this.gender=gender;
        this.price=price;
        this.brand=brand;
        this.size=size;
        this.image_url=image_url;
    }

}