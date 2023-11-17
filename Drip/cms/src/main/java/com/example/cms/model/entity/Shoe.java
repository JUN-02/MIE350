/*package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "shoes")
public class Shoe {

    @Id
    @NotEmpty
    private int shoeId;

    @NotEmpty
    private String shoeName;

    @NotEmpty
    private String color;

    @NotEmpty
    private String type;

    @NotEmpty
    private String gender;

    @NotEmpty
    private Float price;

    @OneToOne
    @MapsId("ratingId")
    @JoinColumn(name = "rating")
    @Nullable
    private int ratingId;

    @ManyToOne
    @MapsId("ratingId")
    @JoinColumn(name = "recommend")
    @Nullable
    private int bundleId;

    @ManyToOne
    @MapsId("brandId")
    @JoinColumn(name = "brandId")
    @Nullable
    private int brandId;

    public Shoe(int shoeId, String shoeName, String color, String type, String gender, Float price, int ratingId, int bundleId, int brandId){
        this.shoeId=shoeId;
        this.shoeName=shoeName;
        this.color=color;
        this.type=type;
        this.gender=gender;
        this.price=price;
        this.ratingId=ratingId;
        this.bundleId=bundleId;
        this.brandId=brandId;


    }

}*/