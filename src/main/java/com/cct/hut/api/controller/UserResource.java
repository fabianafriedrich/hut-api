package com.cct.hut.api.controller;

import com.cct.hut.api.enums.Roles;
import com.cct.hut.api.jwt.JwtTokenProvider;
import com.cct.hut.api.model.User;
import com.cct.hut.api.service.EmailService;
import com.cct.hut.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/*Controller/Resources Layer to handle all the request that come from the UI*/
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private JwtTokenProvider tokenProvider;

    /*Spring Dependence Injection */
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    /*HTTP get methods to list all the results*/
    @GetMapping
    public List<User> getAll(){
        return userService.listAll();
    }


    /*HTTP get method to list by id the results*/
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    /*HTTP put method to update user*/
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid User user) {
        if(!user.getPassword().startsWith("$2a") ){
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }
        userService.update(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    /*HTTP Delete method to remove user by id*/
    @DeleteMapping (value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userService.delete(userService.findById(id));
        return new ResponseEntity<User>(HttpStatus.OK);
    }
    @PostMapping("/registration")
    public ResponseEntity<?> register(@RequestBody User user){
        System.out.println("####### BATEU AQUI EM #######");
        if(userService.findByEmail(user.getEmail()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Roles.STUDENT);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        try {
            return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/login")
    public ResponseEntity<?> getUser(Principal principal){
        if(principal == null){
            //logout will also use here so we should return ok http status.
            return ResponseEntity.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) principal;

        User user = userService.findByEmail(authenticationToken.getName());
        user.setToken(tokenProvider.generateToken(authenticationToken));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /*Endpoint to send email*/
    @PostMapping("/contactus")
    public ResponseEntity<User> sendEmail(@RequestBody @Valid User user){
        try {
            emailService.sendEmail(user);
            return new ResponseEntity<>(user,  HttpStatus.OK);
        } catch( MailException e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
