/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.AltoTurmeque.repository.CRUD;

import com.niltonrodriguez.AltoTurmeque.entity.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author niltonrodriguez
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
    
    // Select the last ID
    Optional<Order> findTopByOrderByIdDesc();
    
    // Return orders by zone
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);
    
    // Retun orders by status.
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
}
