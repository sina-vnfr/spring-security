package com.example.springsecuritydemo.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
}
