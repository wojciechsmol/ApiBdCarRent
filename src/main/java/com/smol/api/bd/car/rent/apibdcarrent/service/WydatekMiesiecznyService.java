package com.smol.api.bd.car.rent.apibdcarrent.service;


import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekMiesiecznyDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekWMiesiacuDto;

import java.util.List;

public interface WydatekMiesiecznyService {

    WydatekMiesiecznyDto getWydatekMiesieczny(int rok, int miesiac, Long idPojazdu);

    List<WydatekWMiesiacuDto> getWszystkieWydatkiWMiesiacu();
    int getWydatekWMiesiacuIndex(int rok, String miesiac, List<WydatekWMiesiacuDto> wszystkieWydatki);
    String getMonthFromInt(int miesiac);


}
