/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonRodriguez.AltoTurmeque.repository;

import com.niltonRodriguez.AltoTurmeque.repository.CRUD.UserCrudRepository;
import com.niltonRodriguez.AltoTurmeque.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author niltonrodriguez
 */
@Repository
public class UserReposotory {
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }
    
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }
    
    public User save(User user){
        return userCrudRepository.save(user);
    }
    
    public boolean existeEmail(String email){
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    public Optional<User> autenticarUsuario(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
