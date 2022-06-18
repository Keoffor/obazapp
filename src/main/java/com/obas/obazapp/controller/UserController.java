package com.obas.obazapp.controller;

import com.obas.obazapp.Service.UserService;
import com.obas.obazapp.model.AddUser;
import com.obas.obazapp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<Users>> allBooks(){
        List<Users> user = userService.AllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity addBook(@RequestBody AddUser adduser){
        try {
            Users user = userService.addUser(adduser);
            return ResponseEntity.status(HttpStatus.OK).body("Added successfully");
        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("email does not exist");
        }

    }

}
