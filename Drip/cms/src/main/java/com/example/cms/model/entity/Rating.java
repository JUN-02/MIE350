/*package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

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

    @NotEmpty
    @Id
    private int ratingId;

    @OneToOne
    @MapsId("userId")
    @JoinColumn(name = "users")
    private User user;

    @NotEmpty
    private float ratingScore;

    @NotEmpty
    private String description;



    public Rating(int ratingId, float ratingScore, String description){
        this.ratingId = ratingId;
        this.ratingScore = ratingScore;
        this.description = description;
    }

}*/