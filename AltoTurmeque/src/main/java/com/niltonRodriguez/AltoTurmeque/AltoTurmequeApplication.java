package com.niltonrodriguez.AltoTurmeque;

import com.niltonrodriguez.AltoTurmeque.repository.CRUD.ClotheCrudRepository;
import com.niltonrodriguez.AltoTurmeque.repository.CRUD.OrderCrudRepository;
import com.niltonrodriguez.AltoTurmeque.repository.CRUD.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AltoTurmequeApplication implements CommandLineRunner{
    
    @Autowired
    private ClotheCrudRepository clotheRepo;
    @Autowired
    private OrderCrudRepository orderRepo;
    @Autowired
    private UserCrudRepository userRepo;
    
    public static void main(String[] args) {
            SpringApplication.run(AltoTurmequeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        clotheRepo.deleteAll();
        orderRepo.deleteAll();
        userRepo.deleteAll();
    }

}
