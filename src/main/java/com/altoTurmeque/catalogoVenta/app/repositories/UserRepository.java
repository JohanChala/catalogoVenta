/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.altoTurmeque.catalogoVenta.app.repositories;

import com.altoTurmeque.catalogoVenta.app.entities.User;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author johan
 */
public interface UserRepository extends JpaRepository<User,Integer>{
        
    @Query("select u from User u where u.email= :email")
    User findByEmail(@Param("email") String email);
    
    @Query("select u from User u where u.email= :email and u.password= :password")
    User findUserAuthenticate(@Param("email") String email,@Param("password") String password);
}
