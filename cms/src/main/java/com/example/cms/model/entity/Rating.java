package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ratings")
public class Rating {

    @Id
    @NotNull
    private long ratingId;

    @ManyToOne
    @JoinColumn(name = "userName")
    private User userName;

    @NotNull
    private float ratingScore;

    @Nullable
    private String description;

    @ManyToOne
    @Nullable
    @JoinColumn(name="shoeId")
    private Shoe shoeId;


    public Rating(long ratingId,User userName, float ratingScore, String description, Shoe shoeId){
        this.ratingId = ratingId;
        this.ratingScore = ratingScore;
        this.description = description;
        this.shoeId=shoeId;
        this.userName=userName;
    }

}