package com.smol.api.bd.car.rent.apibdcarrent.service;


import com.smol.api.bd.car.rent.apibdcarrent.model.Pojazd;
import com.smol.api.bd.car.rent.apibdcarrent.model.PojazdDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.Wypozyczenie;

import java.time.LocalDateTime;
import java.util.List;

public interface PojazdService {

    List<Pojazd> getAllPojazdy();
    Pojazd createPojazd(PojazdDto pojazdDto);
    List<Pojazd> getAllAvailablePojazdy(String from, String to);
    PojazdDto convertToDto(Pojazd pojazd);
    Pojazd convertFromDto(PojazdDto pojazdDto);
}