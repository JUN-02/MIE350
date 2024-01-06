package com.example.cms.model.repository;

import com.example.cms.model.entity.Rating;
import com.example.cms.model.entity.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query(value =  "select * from ratings r " +
            "where r.shoeId = :shoeName", nativeQuery = true)
    List<Rating> findShoeRatings(@Param("shoeName") Long shoeName);

    @Query(value = "SELECT * FROM ratings r WHERE r.userName = :userName AND r.shoeId = :shoeId", nativeQuery = true)
    List<Rating> findRating(@Param("userName") String username, @Param("shoeId") Long shoeId);
}
