/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.AltoTurmeque.controller;

import com.niltonrodriguez.AltoTurmeque.entity.Clothe;
import com.niltonrodriguez.AltoTurmeque.service.ClotheService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author niltonrodriguez
 */
@RestController
@RequestMapping("/api/clothe")
public class ClotheController {
    @Autowired
    private ClotheService service;
    
    @GetMapping("/all")
    public List<Clothe> getAll(){
        return service.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Clothe> getClothe(@PathVariable("reference")String reference){
        return service.getClothe(reference);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe create(@RequestBody Clothe clothe){
        return service.create(clothe);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe update(@RequestBody Clothe clothe){
        return service.update(clothe);
    }
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String id){
        return service.delete(id);
    }
}
