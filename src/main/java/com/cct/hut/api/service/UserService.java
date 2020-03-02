package com.cct.hut.api.service;

import com.cct.hut.api.controller.UserResource;
import com.cct.hut.api.model.User;
import com.cct.hut.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/*Service Layer to handle business rules if it have to
 * And communicate with repository layer*/
@Service
public class UserService {
    /*Spring Dependence Injection */
    @Autowired
    private UserRepository userRepository;

    /*Method to save user on database*/
    public User save(User user){
        return userRepository.save(user);
    }
    /*Method to list all user on database*/
    public List<User> listAll(){
        return userRepository.findAll();
    }

    /*Method to find user by id on database*/
    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
    /*Method to update user on database*/
    public void update(User user){
       userRepository.save(user);
    }



}
