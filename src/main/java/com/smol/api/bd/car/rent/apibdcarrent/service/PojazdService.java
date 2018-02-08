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

    Pojazd getPojazd(Long pojazdId);

    Pojazd updatePojazd(Long pojazdId, PojazdDto pojazdDetails);

    List<Pojazd> getAllPojazdyWNaprawie();

    PojazdDto convertToDto(Pojazd pojazd);

    Pojazd convertFromDto(PojazdDto pojazdDto);
}
