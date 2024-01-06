package com.example.cms.model.repository;

import com.example.cms.model.entity.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Long> {
    @Query(value =  "select * from shoes s " +
            "where lower(s.brand) like lower(concat('%',:brand,'%'))", nativeQuery = true)
    List<Shoe> findBrand(@Param("brand") String brandName);

    @Query(value =  "select * from shoes s " +
            "where lower(s.gender) like lower(concat('%',:gender,'%'))", nativeQuery = true)
    List<Shoe> findGender(@Param("gender") String gender);

    @Query(value =  "select * from shoes s " +
            "where lower(s.type) like lower(concat('%', :type, '%'))", nativeQuery = true)
    List<Shoe> findType(@Param("type") String type);

    @Query(value =  "select * from shoes s " +
            "where s.size = :size", nativeQuery = true)
    List<Shoe> findSize(@Param("size") float size);

    @Query(value =  "select * from shoes s " +
            "where s.price>=:min and s.price<=:max", nativeQuery = true)
    List<Shoe> findPriceRange(@Param("min") float min, @Param("max") float max);
    
    @Query(value =  "select * from shoes s " +
            "where lower(s.color) = lower('%', :color, '%'))", nativeQuery = true)
    List<Shoe> findColor(@Param("color") String color);

    @Query(value =  "select * from shoes s " +
            "where s.shoeId = :shoeId", nativeQuery = true)
    List<Shoe> findShoeList(@Param("shoeId") Long shoeId); //list version of find shoe, since table display on appsmith requires list not object

    @Query(value =  "select * from shoes s " +
            "where s.shoeId = :shoeId", nativeQuery = true)
    Shoe findShoe(@Param("shoeId") Long shoeId);

    //@Query(value =  "select * from shoes s " +
      //      "where lower(s.color) == lower('%', :color, '%'))", nativeQuery = true)
    //List<Shoe> getAllBrands(@Param("color") String color);
}