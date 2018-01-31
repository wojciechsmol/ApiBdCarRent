package com.smol.api.bd.car.rent.apibdcarrent.service;


import com.smol.api.bd.car.rent.apibdcarrent.model.Wypozyczenie;
import com.smol.api.bd.car.rent.apibdcarrent.repository.WypozyczenieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WypozyczenieServiceImpl implements WypozyczenieService {

    private WypozyczenieRepository wypozyczenieRepository;

    @Autowired
    public WypozyczenieServiceImpl(WypozyczenieRepository wypozyczenieRepository) {
        this.wypozyczenieRepository = wypozyczenieRepository;
    }

    @Override
    public List<Wypozyczenie> getAllWypozyczenia() {
        List<Wypozyczenie> wypozyczenia = new ArrayList<>();
        wypozyczenieRepository.findAll().forEach(wypozyczenia::add);
        return wypozyczenia;
    }
}
