package com.brtest.brtest.controllers;

import com.brtest.brtest.Entities.User.User;
import com.brtest.brtest.Services.UserService;
import com.brtest.brtest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    public UserService userService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users/")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/Users/")
    public ResponseEntity<User> AddUser(User user){
        userService.AddUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping ("/users/{id}/")
    public ResponseEntity<Void> DeleteUser(@PathVariable Integer id){
        User user = userService.getUserById(id);
        userService.DeleteUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/users/{id}/")
    public ResponseEntity<User> Updateser(@PathVariable Integer id){
        User user = userService.getUserById(id);
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping("/users/{id}/")
    public ResponseEntity<Optional<User>> getuser(@PathVariable Integer id){
        Optional<User> findUser = userRepository.findById(id);
        return new ResponseEntity<>(findUser, HttpStatus.OK);
    }



}
