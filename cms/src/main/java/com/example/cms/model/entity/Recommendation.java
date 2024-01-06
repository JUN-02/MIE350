package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "recommendations")
public class Recommendation {
    @Id
    @NotEmpty
    private Long recommendationId;

    @NotEmpty
    private String recommendName;

    @NotEmpty
    private String description;

    //@OneToMany(mappedBy = "recommendations")
    //@Nullable
    //private List<ShoeRecommendation> shoeRecs = new ArrayList<>();


    public Recommendation(Long recommendationId, String recommendName, String description) {
        this.recommendationId = recommendationId;
        this.recommendName = recommendName;
        this.description = description;
    }
}
