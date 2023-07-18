package com.annyw.microservices.service;

import com.annyw.microservices.repo.HobbiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RelationshipService {
    @Autowired
    HobbiesRepo hobbiesRepo;

    public List<String> getHobbiesById(int id){
         List<String> result = hobbiesRepo.getHobbies(id);
        return result;
    }
}
