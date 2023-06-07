package com.project.store.superstore.controllers;

import com.project.store.superstore.dto.UserDTO;
import com.project.store.superstore.models.ResponseObject;
import com.project.store.superstore.repositories.UserRepository;
import com.project.store.superstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("")
    public String home(){
        return "User";
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getUserById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getUserById(id));
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertUser (@RequestBody UserDTO newUser){
        return ResponseEntity.status(HttpStatus.OK).body(service.createUser(newUser));
    }
}
