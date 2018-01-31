package com.smol.api.bd.car.rent.apibdcarrent.service;


import com.smol.api.bd.car.rent.apibdcarrent.model.Wypozyczenie;
import com.smol.api.bd.car.rent.apibdcarrent.repository.WypozyczenieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WypozyczenieServiceImpl implements WypozyczenieService {

    private WypozyczenieRepository wypozyczenieRepository;

    @Autowired
    public WypozyczenieServiceImpl(WypozyczenieRepository wypozyczenieRepository) {
        this.wypozyczenieRepository = wypozyczenieRepository;
    }

    @Override
    public Iterable<Wypozyczenie> getAllWypozyczenia() {
        return wypozyczenieRepository.findAll();
    }
}
