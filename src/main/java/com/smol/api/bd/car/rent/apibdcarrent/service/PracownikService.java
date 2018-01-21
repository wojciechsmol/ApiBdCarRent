package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Pracownik;
import org.springframework.http.ResponseEntity;

public interface PracownikService {

    Iterable<Pracownik> getAllPracownicy();
    ResponseEntity<Pracownik> updatePracownik(Long pracownikId, Pracownik pracownikDetails);
    ResponseEntity<Pracownik> createPracownik(Pracownik pracownik);
    ResponseEntity<Pracownik> deletePracownik(Long pracownikId);
}
