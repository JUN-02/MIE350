package com.example.cms.model.repository;

import com.example.cms.model.entity.Recommendation;
import com.example.cms.model.entity.ShoeRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    @Query(value =  "select * from  recommendations r where r.recommendationId = :recommendationId", nativeQuery = true)
    List<Recommendation> getRecommend(@Param("recommendationId") Long recommendationId);
}
