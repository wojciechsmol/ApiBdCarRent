package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.Wypozyczenie;
import com.smol.api.bd.car.rent.apibdcarrent.model.WypozyczenieDto;
import com.smol.api.bd.car.rent.apibdcarrent.service.WypozyczenieService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.POST;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/wypozyczenia")
@RestController
public class WypozyczenieController {

    private WypozyczenieService mWypozyczenieService;

    @Autowired
    public WypozyczenieController(WypozyczenieService wypozyczenieService) {
        mWypozyczenieService = wypozyczenieService;

    }

    @GetMapping("")
    public List<WypozyczenieDto> getAllWypozyczenia() {
        List<Wypozyczenie> wypozyczenia = mWypozyczenieService.getAllWypozyczenia();
        return wypozyczenia.stream()
                .map(wypozyczenie -> mWypozyczenieService.convertToDto(wypozyczenie))
                .collect(Collectors.toList());

    }

    @PatchMapping("/{id}")
    public ResponseEntity<WypozyczenieDto> updateWypozyczenie(@PathVariable(value = "id") Long wypozyczenieId,
                                                              @Valid @RequestBody WypozyczenieDto wypozyczenieDetails) {
        Wypozyczenie wypozyczenie = mWypozyczenieService.updateWypozyczenie(wypozyczenieId, wypozyczenieDetails);
        if (wypozyczenie == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(mWypozyczenieService.convertToDto(wypozyczenie));
    }

    @PostMapping("")
    public ResponseEntity<WypozyczenieDto> createWypozyczenie(@Valid @RequestBody WypozyczenieDto wypozyczenieDto) {
        Wypozyczenie wypozyczenie = mWypozyczenieService.createWypozyczenie(wypozyczenieDto);
        if (wypozyczenie == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(mWypozyczenieService.convertToDto(wypozyczenie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WypozyczenieDto> getWypozyczenie(@PathVariable(value = "id") Long wypozyczenieId) {
        Wypozyczenie wypozyczenie = mWypozyczenieService.getWypozyczenie(wypozyczenieId);
        if(wypozyczenie == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(mWypozyczenieService.convertToDto(wypozyczenie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WypozyczenieDto> deleteWypozyczenie(@PathVariable(value = "id") Long wypozyczenieId){
        boolean successful = mWypozyczenieService.deleteWypozyczenie(wypozyczenieId);
        if(!successful)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }
}
