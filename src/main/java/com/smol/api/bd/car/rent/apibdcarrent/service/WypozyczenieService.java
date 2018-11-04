package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Pracownik;
import com.smol.api.bd.car.rent.apibdcarrent.model.Wypozyczenie;
import com.smol.api.bd.car.rent.apibdcarrent.model.WypozyczenieDto;

import java.util.List;

public interface WypozyczenieService {
    List<Wypozyczenie> getAllWypozyczenia();

    Wypozyczenie updateWypozyczenie(Long wypozyczenieId, WypozyczenieDto wypozyczenieDetails);

    Wypozyczenie createWypozyczenie(WypozyczenieDto wypozyczenieDto);

    WypozyczenieDto convertToDto(Wypozyczenie wypozyczenie);

    Wypozyczenie getWypozyczenie(Long wypozyczenieId);

    boolean deleteWypozyczenie(Long wypozyczenieId);

    Wypozyczenie convertFromDto(WypozyczenieDto wypozyczenieDto);

}
