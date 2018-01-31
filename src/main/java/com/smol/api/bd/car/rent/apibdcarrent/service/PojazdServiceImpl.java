package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Pojazd;
import com.smol.api.bd.car.rent.apibdcarrent.model.Wypozyczenie;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PojazdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PojazdServiceImpl implements PojazdService{

    PojazdRepository mPojazdRepository;

    @Autowired

    public PojazdServiceImpl(PojazdRepository pojazdRepository) {
        mPojazdRepository = pojazdRepository;
    }

    @Override
    public List<Pojazd> getAllPojazdy() {
        List<Pojazd> pojazdy = new ArrayList<>();
        mPojazdRepository.findAll().forEach(pojazdy::add);
        return pojazdy;
    }


}
