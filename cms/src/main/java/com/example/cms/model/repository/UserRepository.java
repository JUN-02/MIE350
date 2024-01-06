package com.example.cms.model.repository;

import com.example.cms.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<User, String> {

    /*@Query(value = "select * from students s " +
            "where lower(s.firstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(s.lastName) like lower(concat('%', :searchTerm, '%'))" +
            "or lower(s.initials) like lower(concat('%', :searchTerm, '%'))", nativeQuery = true)
    /*List<Student> search(@Param("searchTerm") String searchTerm);*/

    @Query(value =  "select * from users u " +
            "where u.userName = :username", nativeQuery = true)
    User findUser(@Param("username") String username);
/*
    @Query(value =  "select * from users u " +
            "where u.userName = :username" +
            "or u.password = :password", nativeQuery = true)
     List<User> matchUser(@Param("username") String username, @Param("password") String password);

    @Query(value = "UPDATE users SET users.password = :newPassword WHERE users.userName = :username",nativeQuery = true)
    List<User> updatePassword(@Param("newPassword") String newPassword, @Param("username") String username);

    @Query(value = "UPDATE users SET users.isLoggedIn = 0", nativeQuery = true)
    void resetLogin();

    @Query(value = "SELECT * FROM USERS u WHERE u.isLoggedIn = 1", nativeQuery = true)
    User findLoggedInUser();

    @Modifying
    @Transactional
    @Query(value = "UPDATE users u SET u.password = :newPassword WHERE u.password = :currentPassword " +
            "AND u.username = :username", nativeQuery = true)
    User changePassword(@Param("username") String username, @Param("currentPassword") String currentPassword, @Param("newPassword") String newPassword);
   */
}

