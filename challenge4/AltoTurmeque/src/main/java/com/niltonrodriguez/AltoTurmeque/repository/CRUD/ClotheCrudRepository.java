/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.AltoTurmeque.repository.CRUD;

import com.niltonrodriguez.AltoTurmeque.entity.Clothe;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author niltonrodriguez
 */
public interface ClotheCrudRepository extends MongoRepository<Clothe, String>{
    
}
