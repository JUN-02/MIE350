package com.example.cms.model.repository;

import com.example.cms.model.entity.Shoe;
import com.example.cms.model.entity.ShoeRecommendation;
import com.example.cms.model.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoeRecommendationRepository extends JpaRepository<ShoeRecommendation, Long> {
    @Query(value =  "select * from  shoeRecs r where r.recommendationId = :recommendationId", nativeQuery = true)
    List<ShoeRecommendation> getRecommendation(@Param("recommendationId") Long recommendationId);

}
