/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.AltoTurmeque.repository;

import com.niltonrodriguez.AltoTurmeque.entity.Order;
import com.niltonrodriguez.AltoTurmeque.repository.CRUD.OrderCrudRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class OrderRepository {
    @Autowired
    private OrderCrudRepository crudRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Order> getAll(){
        return (List<Order>)crudRepository.findAll();
    }
    
    public Optional<Order> getOrder(int id){
        return crudRepository.findById(id);
    }
    
    public Order create(Order order){
        return crudRepository.save(order);
    }
    
    public void update(Order order){
        crudRepository.save(order);
    }
    
    public void delete(Order order){
        crudRepository.delete(order);
    }
    
    public Optional<Order> lastOrderId(){
        return crudRepository.findTopByOrderByIdDesc();
    }
    
    public List<Order> findByZone(String zone){
        return crudRepository.findByZone(zone);
    }
    
    public List<Order> ordersSalesManById(Integer id){
        
        Query query = new Query();
        Criteria idCriteria = Criteria.where("salesMan.id").is(id);
        
        query.addCriteria(idCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);
        
        return orders;
    }
    
    public List<Order> ordersSalesManByState(String state, int id){
        
        Query query = new Query();
        Criteria stateCriteria = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);
        
        query.addCriteria(stateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);
        
        return orders;
    }
    
    public List<Order> ordersSalesManByDate(String dateStr, int id){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, formatter).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, formatter).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);
        
        query.addCriteria(dateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);
        
        return orders;
    }

}
