package com.smol.api.bd.car.rent.apibdcarrent.service;


import com.smol.api.bd.car.rent.apibdcarrent.model.Pojazd;
import com.smol.api.bd.car.rent.apibdcarrent.model.PojazdDto;

import java.util.List;

public interface PojazdService {

    List<Pojazd> getAllPojazdy();

    PojazdDto convertToDto(Pojazd pojazd);
}
