package com.annyw.microservices.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_courses", schema = "Courses")
public class Relationship {
    
    @Id
    @Column(name="user_id", nullable = false)
    private int user_id;
    
    @Column(name="course_id", nullable = false)
    private int course_id;
    
}
