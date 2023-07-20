package com.annyw.microservices.bean;

import jakarta.persistence.*;

@Entity
public class Courses {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    
    @Basic
    @Column(name = "name", nullable = false, length = 24)
    private String name;
}
