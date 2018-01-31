package com.smol.api.bd.car.rent.apibdcarrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiBdCarRentApplication {


    public static void main(String[] args) {

        System.out.println(Integer.getInteger("4"));
        SpringApplication.run(ApiBdCarRentApplication.class, args);

    }


}
