package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.Pracownik;
import com.smol.api.bd.car.rent.apibdcarrent.model.PracownikDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.Wypozyczenie;
import com.smol.api.bd.car.rent.apibdcarrent.service.PracownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/pracownicy")
@RestController
public class PracownikController {

    private PracownikService pracownikService;

    @Autowired
    public PracownikController(PracownikService pracownikService) {
        this.pracownikService = pracownikService;
    }

    @GetMapping("")
    public List<PracownikDto> getAllPracownicy() {

        List<Pracownik> pracownicy = pracownikService.getAllPracownicy();
        return pracownicy.stream()
                .map(pracownik -> pracownikService.convertToDto(pracownik))
                .collect(Collectors.toList());
    }

    @PostMapping("")
    public ResponseEntity<PracownikDto> createPracownik(@Valid @RequestBody PracownikDto pracownikDto) {
        return ResponseEntity.ok(pracownikService.convertToDto(pracownikService.createPracownik(pracownikDto)));
    }


    @GetMapping("/{id}")
    public ResponseEntity<PracownikDto> getPracownik(@PathVariable(value = "id") Long pracownikId) {
        Pracownik pracownik = pracownikService.getPracownik(pracownikId);
        if (pracownik == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(pracownikService.convertToDto(pracownik));
    }

    @GetMapping("/opiekuni")
    public List<PracownikDto> getAllOpiekuni() {
        List<Pracownik> pracownicy = pracownikService.getAllOpiekuni();
        return pracownicy.stream()
                .map(pracownik -> pracownikService.convertToDto(pracownik))
                .collect(Collectors.toList());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PracownikDto> updatePracownik(@PathVariable(value = "id") Long pracownikId,
                                                        @Valid @RequestBody PracownikDto pracownikDetails) {

        Pracownik pracownik = pracownikService.updatePracownik(pracownikId, pracownikDetails);
        if (pracownik == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(pracownikService.convertToDto(pracownik));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PracownikDto> deletePracownik(@PathVariable(value = "id") Long pracownikId) {
        boolean successful = pracownikService.deletePracownik(pracownikId);
        if (!successful)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }


}
