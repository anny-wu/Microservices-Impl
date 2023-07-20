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
}
