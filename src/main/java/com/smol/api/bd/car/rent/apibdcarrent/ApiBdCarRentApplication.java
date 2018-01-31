package com.smol.api.bd.car.rent.apibdcarrent;

import org.aspectj.lang.annotation.Before;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiBdCarRentApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApiBdCarRentApplication.class, args);

    }


}
