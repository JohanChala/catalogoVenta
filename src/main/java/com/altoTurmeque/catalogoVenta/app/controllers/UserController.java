/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altoTurmeque.catalogoVenta.app.controllers;

import com.altoTurmeque.catalogoVenta.app.entities.User;
import com.altoTurmeque.catalogoVenta.app.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author johan
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins="*")
public class UserController {
    @Autowired
    private UserService service;
    
    @GetMapping("/all")
    public List<User> findAllClient(){
        return service.getUsers();
    }
    
    @GetMapping("/{email}")
    public boolean emailExist(@PathVariable ("email") String email){
        return service.emailExist(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User userAuthenticate(@PathVariable ("email") String email, @PathVariable ("password") String password){
        return service.userAuthenticate(email, password);
    }
    
    @PostMapping("/new")
    public ResponseEntity newUser(@RequestBody User user){
        service.newUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    
    
}
