package com.example.cms.model.entity;

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
@Table(name = "shoeRecs")

public class ShoeRecommendation {

    @EmbeddedId
    ShoeRecommendationKey shoeRecId;

    @ManyToOne
    @MapsId("shoeId")
    @JoinColumn(name = "shoeId")
    @JsonIgnoreProperties({"shoeRecs"})
    private Shoe shoe;

    @ManyToOne
    @MapsId("recommendationId")
    @JoinColumn(name = "recommendationId")
    @JsonIgnoreProperties({"shoeRecs"})
    private Recommendation recommendation;

}
