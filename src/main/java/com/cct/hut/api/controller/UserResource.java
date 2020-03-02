package com.cct.hut.api.controller;

import com.cct.hut.api.model.User;
import com.cct.hut.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*Controller/Resources Layer to handle all the request that come from the UI*/
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    /*Spring Dependence Injection */
    @Autowired
    private UserService userService;

    /*HTTP get methods to list all the results*/
    @GetMapping
    public List<User> getAll(){
        return userService.listAll();
    }

    /*HTTP post methods to persist user*/
    @PostMapping
    public ResponseEntity<User> add(@RequestBody @Valid User user){
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    /*HTTP get methods to list by id the results*/
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody @Valid User user) {
        userService.update(user);
        return ResponseEntity.ok().build();
    }



}
