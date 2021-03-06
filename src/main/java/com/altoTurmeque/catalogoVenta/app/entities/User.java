/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altoTurmeque.catalogoVenta.app.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author johan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User implements Serializable {
   @Id 
   @GeneratedValue( strategy = GenerationType.IDENTITY)
   private Integer id;
   
    @Column(nullable=false,length=50,unique=true)
    private String email;
    
    @Column(nullable=false,length=50)
    private String password;  
    
    @Column(nullable=false,length=80)
    private String name;
    
    
}
