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
    /**
     * Declaracion de parametros
     */
    @Autowired
    private UserService service;
    
    /**
     * Metodo para obtener todos los usuarios
     * @return 
     */
    @GetMapping("/all")
    public List<User> findAllUser(){
        return service.getUsers();
    }
    
    /**
     * Metododo para verificar la existencia de un email
     * @param email
     * @return 
     */
    @GetMapping("/{email}")
    public boolean emailExist(@PathVariable ("email") String email){
        return service.emailExist(email);
    }
    
    /**
     * Metodo para verificar la existencia de una cuenta
     * @param email
     * @param password
     * @return 
     */
    @GetMapping("/{email}/{password}")
    public User userAuthenticate(@PathVariable ("email") String email, @PathVariable ("password") String password){
        return service.userAuthenticate(email, password);
    }
    
    /**
     * Metodo para registrar un nuevo usuario
     * @param user
     * @return 
     */
    @PostMapping("/new")
    public ResponseEntity newUser(@RequestBody User user){
        service.newUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }    
}
