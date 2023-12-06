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

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/")
    public ResponseEntity<User> AddUser(@RequestBody User user){
        System.out.println(user.getFirstName());
        Boolean response = userService.AddUser(user);
        return response ?  new ResponseEntity<>(user, HttpStatus.OK): new ResponseEntity<>(user, HttpStatus.BAD_REQUEST) ;
    }


    @GetMapping("/users/")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @DeleteMapping ("/users/{id}/")
    public ResponseEntity<Void> DeleteUser(@PathVariable Integer id){
        User user = userService.getUserById(id);
        userService.DeleteUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/users/{id}/")
    public ResponseEntity<User> UpdateUser(@RequestBody User userreq){
        userService.updateUser(userreq);
        return new ResponseEntity<>(userreq, HttpStatus.OK);
    }


    @GetMapping("/users/{id}/")
    public ResponseEntity<Optional<User>> getuser(@PathVariable Integer id){
        Optional<User> findUser = Optional.ofNullable(userService.getUserById(id));
        return new ResponseEntity<>(findUser, HttpStatus.OK);
    }



}
