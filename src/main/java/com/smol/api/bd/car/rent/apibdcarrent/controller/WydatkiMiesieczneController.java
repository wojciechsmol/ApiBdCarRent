package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekMiesiecznyDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekRocznyDto;
import com.smol.api.bd.car.rent.apibdcarrent.service.WydatekMiesiecznyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/wydatkiMiesieczne")
@RestController
public class WydatkiMiesieczneController {

    private WydatekMiesiecznyService mWydatekMiesiecznyService;

    @Autowired
    public WydatkiMiesieczneController(WydatekMiesiecznyService wydatekMiesiecznyService) {
        mWydatekMiesiecznyService = wydatekMiesiecznyService;
    }

    @GetMapping("")
    public ResponseEntity<WydatekMiesiecznyDto> getWydatekMiesieczny(@RequestParam("rok") int rok,
                                                                 @RequestParam("miesiac") int miesiac,
                                                                 @RequestParam("id_pojazdu") Long idPojazdu) {
        return ResponseEntity.ok(mWydatekMiesiecznyService.getWydatekMiesieczny(rok, miesiac, idPojazdu));
    }
}
