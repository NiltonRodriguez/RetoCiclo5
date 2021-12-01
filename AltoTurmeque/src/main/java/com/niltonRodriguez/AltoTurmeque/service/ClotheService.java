/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.AltoTurmeque.service;

import com.niltonrodriguez.AltoTurmeque.entity.Clothe;
import com.niltonrodriguez.AltoTurmeque.repository.ClotheRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author niltonrodriguez
 */
@Service
public class ClotheService {
    @Autowired
    private ClotheRepository repository;
    
    public List<Clothe> getAll(){
        return repository.getAll();
    }
    
    public Optional<Clothe> getClothe(String id){
        return repository.getClothe(id);
    }
    
    public Clothe create(Clothe clothe){
        if(clothe.getReference() == null){
            return clothe;
        } else {
            Optional<Clothe> check = repository.getClothe(clothe.getReference());
            if(check.isEmpty()){    
                return repository.create(clothe);
            } else {
                return clothe;
            }
        }
    }
    
    public Clothe update(Clothe clothe){
        if (clothe.getReference() != null){
            Optional<Clothe> checkClothe = repository.getClothe(clothe.getReference());
            if(!checkClothe.isEmpty()){
                if(clothe.getCategory() != null){
                    checkClothe.get().setCategory(clothe.getCategory());
                }
                if(clothe.getSize()!= null){
                    checkClothe.get().setSize(clothe.getSize());
                }
                if(clothe.getDescription()!= null){
                    checkClothe.get().setDescription(clothe.getDescription());
                }
                if(clothe.getPhotography()!= null){
                    checkClothe.get().setPhotography(clothe.getPhotography());
                }
                repository.update(checkClothe.get());
                return checkClothe.get();
            } else {
                return clothe;
            }
        } else {
            return clothe;
        }
    }
    
    public boolean delete(String id){
        Boolean aBoolean= getClothe(id).map(user -> {
            repository.delete(id);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
}
