/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.AltoTurmeque.service;

import com.niltonrodriguez.AltoTurmeque.entity.User;
import com.niltonrodriguez.AltoTurmeque.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author niltonrodriguez
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    
    public List<User> getAll(){
        return repository.getAll();
    }
    
    public Optional<User> getUser(int id){
        return repository.getUser(id);
    }
    
    public boolean existEmail(String email){
        return repository.existEmail(email);
    }
    
    public User authenticateUser(String email, String password){
        Optional<User> user = repository.authenticateUser(email, password);
        
        if(user.isEmpty()){
            return new User();
        }else{
            return user.get();
        }
    }
    
    public User create(User user){
        if (user.getId() == null){
                return user;
        }else{
            Optional<User> check = repository.getUser(user.getId());
            if (check.isEmpty()){
                if(existEmail(user.getEmail()) == false){
                    return repository.create(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }

    public User update(User user){
        if(user.getId() != null){
            Optional<User> checkUser = repository.getUser(user.getId());
            if(!checkUser.isEmpty()){
                if (user.getIdentification() != null) {
                    checkUser.get().setIdentification(user.getIdentification());
                }
                if (user.getName()!= null) {
                    checkUser.get().setName(user.getName());
                }
                if (user.getAddress()!= null) {
                    checkUser.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone()!= null) {
                    checkUser.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail()!= null) {
                    checkUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword()!= null) {
                    checkUser.get().setPassword(user.getPassword());
                }
                if (user.getZone()!= null) {
                    checkUser.get().setZone(user.getZone());
                }
                if (user.getType()!= null) {
                    checkUser.get().setType(user.getType());
                }
                
                repository.update(checkUser.get());
                return checkUser.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public boolean delete(int id){
        Boolean aBoolean= getUser(id).map(user -> {
            repository.delete(id);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
}
