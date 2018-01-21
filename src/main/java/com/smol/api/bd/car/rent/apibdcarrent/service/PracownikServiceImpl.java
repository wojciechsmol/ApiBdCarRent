package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Pracownik;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PracownikServiceImpl implements PracownikService {

    PracownikRepository pracownikRepository;

    @Autowired
    public PracownikServiceImpl(PracownikRepository pracownikRepository){
        this.pracownikRepository = pracownikRepository;
    }

    @Override
    public Iterable<Pracownik> getAllPracownicy() {
        return pracownikRepository.findAll();
    }

    @Override
    public ResponseEntity<Pracownik> updatePracownik(Long pracownikId, Pracownik pracownikDetails) {
        Pracownik pracownik = pracownikRepository.findOne(pracownikId);
        if (pracownik == null) {
            return ResponseEntity.notFound().build();
        }

        pracownik.setDataUrodzenia(pracownikDetails.getDataUrodzenia());
        pracownik.setImie(pracownikDetails.getImie());
        pracownik.setNazwisko(pracownikDetails.getNazwisko());
        pracownik.setPesel(pracownikDetails.getPesel());
        pracownik.setRola(pracownikDetails.getRola());
        pracownik.setStatusZatrudnienia(pracownikDetails.getStatusZatrudnienia());

        pracownikRepository.save(pracownik);
        return ResponseEntity.ok(pracownik);
    }

    @Override
    public ResponseEntity<Pracownik> createPracownik(Pracownik pracownik) {
        pracownikRepository.save(pracownik);
        return ResponseEntity.ok(pracownik);
    }

    @Override
    public ResponseEntity<Pracownik> deletePracownik(Long pracownikId) {
        Pracownik pracownik = pracownikRepository.findOne(pracownikId);
        if (pracownik == null) {
            return ResponseEntity.notFound().build();
        }

        pracownikRepository.delete(pracownik);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Pracownik> getPracownik(Long pracownikId) {
        Pracownik pracownik = pracownikRepository.findOne(pracownikId);
        if (pracownik == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pracownik);
    }

}
