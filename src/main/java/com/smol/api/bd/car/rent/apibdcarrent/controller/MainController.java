package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.repository.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MainController {

    private PracownikRepository pracownikRepository;

    @Autowired
    MainController(PracownikRepository pracownikRepository){
        this.pracownikRepository = pracownikRepository;
    }

    @RequestMapping("/")
    public String mainfunc() {
        return "OPCJE:\n " +
                "GET: /pracownicy\n " +
                "GET: /pracownicy/statusy_zatrudnienia\n " +
                "GET: /pracownicy/role\n" +
                "GET: /pracownicy/{id} - zwraca konkretnego pracownika\n" +
                "PUT: /pracownicy/{id}  -  i przekazujemy to co chcemy zmienić JSON-em\n" +
                "DELETE: /pracownicy/{id}\n" +
                "POST: /pracownicy";
    }


}
