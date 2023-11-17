package com.example.cms.model.repository;

import com.example.cms.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /*@Query(value = "select * from students s " +
            "where lower(s.firstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(s.lastName) like lower(concat('%', :searchTerm, '%'))" +
            "or lower(s.initials) like lower(concat('%', :searchTerm, '%'))", nativeQuery = true)
    /*List<Student> search(@Param("searchTerm") String searchTerm);*/


    @Query(value =  "select * from users u " +
            "where u.userName == :username" +
            "or u.password == :password", nativeQuery = true)
     List<User> findUser(@Param("username") String username, @Param("password") String password);

    @Query(value = "UPDATE users SET users.password = :newPassword WHERE users.userName = :username",nativeQuery = true)
    List<User> updatePassword(@Param("newPassword") String newPassword, @Param("username") String username);


}
