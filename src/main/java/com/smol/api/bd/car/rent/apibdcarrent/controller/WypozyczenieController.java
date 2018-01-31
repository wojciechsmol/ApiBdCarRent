package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.Wypozyczenie;
import com.smol.api.bd.car.rent.apibdcarrent.service.WypozyczenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wypozyczenia")
@RestController
public class WypozyczenieController {

    private WypozyczenieService mWypozyczenieService;

    @Autowired

    public WypozyczenieController(WypozyczenieService wypozyczenieService) {
        mWypozyczenieService = wypozyczenieService;
    }

    @GetMapping("")
    public Iterable<Wypozyczenie> getAllWypozyczenia(){
        return mWypozyczenieService.getAllWypozyczenia();
    }


}
