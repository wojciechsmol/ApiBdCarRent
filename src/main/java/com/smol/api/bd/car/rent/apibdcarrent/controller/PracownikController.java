package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.Pracownik;
import com.smol.api.bd.car.rent.apibdcarrent.service.PracownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.EnumSet;

@RequestMapping("/pracownicy")
@RestController
public class PracownikController {

    private PracownikService pracownikService;

    @Autowired
    public PracownikController(PracownikService pracownikService) {
        this.pracownikService = pracownikService;
    }

    @GetMapping("")
    public Iterable<Pracownik> getAllPracownicy() {
        return pracownikService.getAllPracownicy();
    }

    @PostMapping("")
    public ResponseEntity<Pracownik> createPracownik(@Valid @RequestBody Pracownik pracownik) {
        return pracownikService.createPracownik(pracownik);
    }

    @GetMapping("/statusy_zatrudnienia")
    public EnumSet<Pracownik.StatusZatrudnienia> getStatusy() {
        return Pracownik.StatusZatrudnienia.allStatusyZatrudnienia;
    }

    @GetMapping("/role")
    public EnumSet<Pracownik.Rola> getRole() {
        return Pracownik.Rola.allRola;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pracownik> updatePracownik(@PathVariable(value = "id") Long pracownikId,
                                                     @Valid @RequestBody Pracownik pracownikDetails) {
        return pracownikService.updatePracownik(pracownikId, pracownikDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pracownik> deletePracownik(@PathVariable(value = "id") Long pracownikId) {
        return pracownikService.deletePracownik(pracownikId);
    }

}
