package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ShoeRecommendationKey implements Serializable {


    @Column(name = "shoeId")
    Long shoeId;

    @Column(name = "recommendationId")
    Long recommendationId;

    @Override
    public int hashCode() {
        String concatString = String.valueOf(shoeId.hashCode()) + String.valueOf(recommendationId.hashCode());
        return concatString.hashCode();
    }

    public ShoeRecommendationKey(){}

    public ShoeRecommendationKey(Long shoeId, Long recommendationId){
        this.setShoeId(shoeId);
        this.setRecommendationId(recommendationId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (o == this)
            return true;
        if (!(o instanceof ShoeRecommendationKey))
            return false;
        ShoeRecommendationKey other = (ShoeRecommendationKey) o;
        return shoeId.equals(other.shoeId) && recommendationId.equals(other.recommendationId);
    }
}
