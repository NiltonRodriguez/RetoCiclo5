package com.niltonrodriguez.AltoTurmeque;

import com.niltonrodriguez.AltoTurmeque.repository.CRUD.ClotheCrudRepository;
import com.niltonrodriguez.AltoTurmeque.repository.CRUD.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AltoTurmequeApplication implements CommandLineRunner{
    
    @Autowired
    private UserCrudRepository userRepo;
    @Autowired
    private ClotheCrudRepository clotheRepo;
    
    public static void main(String[] args) {
            SpringApplication.run(AltoTurmequeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepo.deleteAll();
        clotheRepo.deleteAll();
    }

}
