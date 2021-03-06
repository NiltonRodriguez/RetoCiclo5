/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.AltoTurmeque.controller;

import com.niltonrodriguez.AltoTurmeque.entity.User;
import com.niltonrodriguez.AltoTurmeque.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author niltonrodriguez
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserControler {
    @Autowired
    private UserService service;
    
    @GetMapping("/all")
    public List<User> getAll(){
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return service.getUser(id);
    }
    
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, 
            @PathVariable("password") String password){
        return service.authenticateUser(email, password);
    }
    
    @GetMapping("emailexist/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return service.existEmail(email);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user){
        return service.create(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return service.update(user);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }
}
