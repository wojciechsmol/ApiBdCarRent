package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Marka;
import com.smol.api.bd.car.rent.apibdcarrent.model.MarkaDto;

public interface MarkaService {

    MarkaDto convertToDto(Marka marka);
}
