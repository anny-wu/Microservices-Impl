package com.annyw.microservices.bean;

import jakarta.persistence.*;

@Entity
@Table(name="info", schema = "Micro")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    
    @Basic
    @Column(name = "username", nullable = false, length = 24)
    private String username;
    
    @Basic
    @Column(name = "age", nullable = false)
    private int age;
    
    public int getId() {
        return id;
    }
}
