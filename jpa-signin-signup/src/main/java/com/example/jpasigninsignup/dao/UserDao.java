package com.example.jpasigninsignup.dao;

import com.example.jpasigninsignup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//dao = data access object
public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
}
