package com.annyw.microservices.bean;

import jakarta.persistence.*;

import java.util.Collection;

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
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
}
