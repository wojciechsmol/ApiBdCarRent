package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.Model;
import com.smol.api.bd.car.rent.apibdcarrent.model.Wypozyczenie;
import com.smol.api.bd.car.rent.apibdcarrent.model.WypozyczenieDto;
import com.smol.api.bd.car.rent.apibdcarrent.service.WypozyczenieService;


import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/wypozyczenia")
@RestController
public class WypozyczenieController {

    private WypozyczenieService mWypozyczenieService;

    @Autowired
    public WypozyczenieController(WypozyczenieService wypozyczenieService) {
        mWypozyczenieService = wypozyczenieService;

    }

    @GetMapping("")
    public List<WypozyczenieDto> getAllWypozyczenia(){
        List<Wypozyczenie> wypozyczenia = mWypozyczenieService.getAllWypozyczenia();
        return wypozyczenia.stream()
                .map(wypozyczenie -> convertToDto(wypozyczenie))
                .collect(Collectors.toList());
    }

    private WypozyczenieDto convertToDto(Wypozyczenie wypozyczenie) {

        return new WypozyczenieDto(wypozyczenie.getId(), wypozyczenie.getPlanowanaDataRozpoczecia(), wypozyczenie.getPlanowanaDataZakonczenia(), wypozyczenie.getFaktycznaDataRozpoczecia(), wypozyczenie.getFaktycznaDataZakonczenia(), wypozyczenie.getPrzebiegRozpoczecia(), wypozyczenie.getPrzebiegZakonczenia(), wypozyczenie.getPracownik().getId(), wypozyczenie.getPojazd().getId(), wypozyczenie.getStatusWypozyczenia());
    }




}
