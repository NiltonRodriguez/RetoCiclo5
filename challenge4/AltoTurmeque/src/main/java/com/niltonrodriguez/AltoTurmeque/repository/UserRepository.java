/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.AltoTurmeque.repository;

import com.niltonrodriguez.AltoTurmeque.entity.User;
import com.niltonrodriguez.AltoTurmeque.repository.CRUD.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author niltonrodriguez
 */
@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository crudRepository;
    
    public List<User> getAll(){
        return (List<User>) crudRepository.findAll();
    }
    
    public Optional<User> getUser(int id){
        return crudRepository.findById(id);
    }
    
    public User create(User user){
        return crudRepository.save(user);
    }
    
    public void update(User user){
        crudRepository.save(user);
    }
    
    public void delete(User user){
        crudRepository.delete(user);
    }
    
    public boolean existEmail(String email){
        Optional<User> user = crudRepository.findByEmail(email);
        return !user.isEmpty();
    }
    
    public Optional<User> authenticateUser(String email, String password){
        return crudRepository.findByEmailAndPassword(email, password);
    }
    
    public Optional<User> lastUserId(){
        return crudRepository.findTopByOrderByIdDesc();
    }
}
