/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.AltoTurmeque.repository;

import com.niltonrodriguez.AltoTurmeque.entity.Clothe;
import com.niltonrodriguez.AltoTurmeque.repository.CRUD.ClotheCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author niltonrodriguez
 */
@Repository
public class ClotheRepository {
    @Autowired
    private ClotheCrudRepository crudRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Clothe> getAll(){
        return crudRepository.findAll();
    }
    
    public Optional<Clothe> getClothe(String reference){
        return crudRepository.findById(reference);
    }
    
    public Clothe create(Clothe clothe){
        return crudRepository.save(clothe);
    }
    
    public void update(Clothe clothe){
        crudRepository.save(clothe);
    }
    
    public void delete(Clothe clothe){
        crudRepository.delete(clothe);
    }
    
    public List<Clothe> findByPrice(double price){
        return crudRepository.findByPrice(price);
    }
    
    public List<Clothe> findByDescriptionLike(String keyword){
        Query query = new Query();
        Criteria keywordCriteria = Criteria.where("description").regex(".*" + keyword + ".*", "i");
        
        query.addCriteria(keywordCriteria);
        List<Clothe> clothes = mongoTemplate.find(query, Clothe.class);
        
        return clothes;
    }
}
