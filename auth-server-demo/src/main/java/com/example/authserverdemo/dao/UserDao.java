package com.example.authserverdemo.dao;

import com.example.authserverdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,String> {

    Optional<User> findUserByUsername(String username);
}
