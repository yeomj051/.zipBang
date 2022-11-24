package com.zipbang.dotzipbang.repository;

import com.zipbang.dotzipbang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select u from User u where u.email = :email and u.password = :password")
    User login(String email,String password);

    @Query(value = "select u from User u where u.email = :email ")
    User userInfo(String email);

    @Query(value = "select u.token from User u where  u.email = :userEmail")
    String getRefreshToken(String userEmail);

    @Transactional
    @Modifying
    @Query(value = "update User u set u.token = :token where u.email=:userEmail")
    void saveRefreshToken(String userEmail,String token);
    @Transactional
    @Modifying
    @Query(value = "update User u set u.token = :token where u.email=:userEmail")
    void deleteRefreshToken(String userEmail,String token);



}
