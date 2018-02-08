package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekRocznyDto;

import java.text.ParseException;

public interface WydatekRocznyService {

    WydatekRocznyDto getWydatekRoczny(int rok, Long idPojazdu);
}
