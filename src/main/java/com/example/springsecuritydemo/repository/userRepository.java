package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.dto.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user, Integer> {
    Boolean existsByUsername(String username);
    user getAllByUsername(String username);

}
