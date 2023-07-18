package com.annyw.microservices.bean;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name="hobbies", schema = "Hobbies")
public class Hobbies {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    
    @Basic
    @Column(name = "name", nullable = false, length = 24)
    private String name;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
