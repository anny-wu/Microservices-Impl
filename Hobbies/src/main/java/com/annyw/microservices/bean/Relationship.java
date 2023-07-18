package com.annyw.microservices.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_hobbies", schema = "Hobbies")
public class Relationship {
    
    @Id
    @Column(name="user_id", nullable = false)
    private int user_id;
    
    @Column(name="hobby_id", nullable = false)
    private int hobbies_id;
    
    public int getUser_id() {
        return user_id;
    }
    
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public int getHobbies_id() {
        return hobbies_id;
    }
    
    public void setHobbies_id(int hobbies_id) {
        this.hobbies_id = hobbies_id;
    }
}
