package com.smol.api.bd.car.rent.apibdcarrent.service;


import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekMiesiecznyDto;

public interface WydatekMiesiecznyService {

    WydatekMiesiecznyDto getWydatekMiesieczny(int rok, int miesiac, Long idPojazdu);
    String getMonthFromInt(int miesiac);


}
