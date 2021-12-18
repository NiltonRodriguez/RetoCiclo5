/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.AltoTurmeque.service;

import com.niltonrodriguez.AltoTurmeque.entity.Order;
import com.niltonrodriguez.AltoTurmeque.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author niltonrodriguez
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    
    public List<Order> getAll(){
        return repository.getAll();
    } 
    
    public Optional<Order> getOrder(int id){
        return repository.getOrder(id);
    }
    
    public Order create(Order order){
        // Get last ID from the collection.
        Optional<Order> maxOrderId = repository.lastOrderId();
        // Check if the parameter ID is null.
        if (order.getId() == null){
            // If there's no max ID, asign it to 1.
            if (maxOrderId.isEmpty()){
                order.setId(1);
            }
            else{
                // If there is a max ID, asign the max + 1.
                order.setId(maxOrderId.get().getId() + 1);
            }
        }
        
        Optional<Order> check = repository.getOrder(order.getId());
        if(check.isEmpty()){
            return repository.create(order);
        } else {
            return order;
        }
    }
    
    public Order update(Order order){
        if (order.getId() != null){
            Optional<Order> check = repository.getOrder(order.getId());
            if(!check.isEmpty()){
                if(order.getStatus() != null){
                    check.get().setStatus(order.getStatus());
                }
                repository.update(check.get());
                return check.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }
    
    public boolean delete(int id){
        Boolean aBoolean= getOrder(id).map(order -> {
            repository.delete(order);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
    
    public List<Order> findByZone(String zone){
        return repository.findByZone(zone);
    }
    
    public List<Order> ordersSalesManById(Integer id){
        return repository.ordersSalesManById(id);
    }
    
    public List<Order> ordersSalesManByState(String state, Integer id){
        return repository.ordersSalesManByState(state, id);
    }
    
    public List<Order> ordersSalesManByDate(String dateStr, Integer id){
        return repository.ordersSalesManByDate(dateStr, id);
    }
    
    
}
