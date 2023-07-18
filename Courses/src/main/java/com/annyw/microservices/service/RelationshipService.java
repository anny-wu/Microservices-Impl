package com.annyw.microservices.service;

import com.annyw.microservices.repo.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RelationshipService {
    @Autowired
    CoursesRepo coursesRepo;

    public List<String> getCoursesById(int id){
         List<String> result = coursesRepo.getCourses(id);
        return result;
    }
}
