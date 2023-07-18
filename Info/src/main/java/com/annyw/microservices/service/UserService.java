package com.annyw.microservices.service;

import com.annyw.microservices.bean.User;
import com.annyw.microservices.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepo userRepo;
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
   
    public User getUserById(int id){
        return userRepo.findById(id).get();
    }
}
