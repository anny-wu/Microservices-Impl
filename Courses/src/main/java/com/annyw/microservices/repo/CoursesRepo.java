package com.annyw.microservices.repo;

import com.annyw.microservices.bean.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursesRepo extends JpaRepository<Courses,Integer> {
    @Query(value ="SELECT name From courses INNER JOIN user_courses uc on courses.id = uc.course_id where uc" +
        ".user_id = ?1", nativeQuery = true)
    List<String> getCourses(@Param("id")int id);
}
