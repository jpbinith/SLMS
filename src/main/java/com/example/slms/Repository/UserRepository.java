package com.example.slms.Repository;

import com.example.slms.Entity.User;
import com.example.slms.Entity.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "Select * from login where user_ID = :userID", nativeQuery = true)
    Optional<User> findUser(@Param("userID") long id);

    @Query(value = "Select user_ID as userID, username from login where user_ID = :userID", nativeQuery = true)
    Optional<UserDetailsProjection> findUserDetails(@Param("userID") long id);

    Optional<User> findByUsername(String username);

}
