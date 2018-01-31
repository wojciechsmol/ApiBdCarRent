package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Pracownik;
import com.smol.api.bd.car.rent.apibdcarrent.model.Wypozyczenie;

public interface WypozyczenieService {
    Iterable<Wypozyczenie> getAllWypozyczenia();
}
