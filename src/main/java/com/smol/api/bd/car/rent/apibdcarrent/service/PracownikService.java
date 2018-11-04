package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Pracownik;
import com.smol.api.bd.car.rent.apibdcarrent.model.PracownikDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PracownikService {

    List<Pracownik> getAllPracownicy();

    Pracownik updatePracownik(Long pracownikId, PracownikDto pracownikDetails);

    Pracownik createPracownik(PracownikDto pracownikDto);

    boolean deletePracownik(Long pracownikId);

    Pracownik getPracownik(Long pracownikId);

    PracownikDto convertToDto(Pracownik pracownik);

    List<Pracownik> getAllOpiekuni();

    Pracownik convertFromDto(PracownikDto pracownikDto);
}
