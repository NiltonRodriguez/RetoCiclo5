/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.AltoTurmeque.repository.CRUD;

import com.niltonrodriguez.AltoTurmeque.entity.User;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author niltonrodriguez
 */
public interface UserCrudRepository extends MongoRepository<User, Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    //List<User> findByBirthtDay(Date birthtDay);
    //List<User> findByMonthBirthtDay(String monthBirthtDay);
    //List<User> findOneByOrderByIdDesc();
    // Select the last ID
    Optional<User> findTopByOrderByIdDesc();
}
