package com.example.cms.model.repository;

import com.example.cms.model.entity.Shoe;
import com.example.cms.model.entity.Wishlist;
import com.example.cms.model.entity.WishlistKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, WishlistKey> {
    @Query(value =  "select * from  shoeWish w where w.userName = :username", nativeQuery = true)
    List<Wishlist> getWishlist(@Param("username") String userName);

}
