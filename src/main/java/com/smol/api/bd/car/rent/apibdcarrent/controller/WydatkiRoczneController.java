package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekRocznyDto;
import com.smol.api.bd.car.rent.apibdcarrent.service.WydatekRocznyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wydatkiRoczne")
@RestController
public class WydatkiRoczneController {

    private WydatekRocznyService mWydatekRocznyService;

    @Autowired
    public WydatkiRoczneController(WydatekRocznyService wydatekRocznyService) {
        mWydatekRocznyService = wydatekRocznyService;
    }

    @GetMapping("")
    public ResponseEntity<WydatekRocznyDto> getWydatekRoczny(@RequestParam("rok") int rok,
                                             @RequestParam("id_pojazdu") Long idPojazdu) {
        return ResponseEntity.ok(mWydatekRocznyService.getWydatekRoczny(rok, idPojazdu));
    }
}
