package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekKierowcyDto;
import com.smol.api.bd.car.rent.apibdcarrent.service.WydatekKierowcyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wydatkiKierowcy")
@RestController
public class WydatkiKierowcyController {

    private WydatekKierowcyService mWydatekKierowcyService;

    @Autowired
    public WydatkiKierowcyController(WydatekKierowcyService wydatekKierowcyService) {
        mWydatekKierowcyService = wydatekKierowcyService;
    }

    @GetMapping("")
    public ResponseEntity<WydatekKierowcyDto> getWydatekKierowcy(@RequestParam("id_kierowcy") Long idKierowcy) {
        return ResponseEntity.ok(mWydatekKierowcyService.getWydatekKierowcy(idKierowcy));
    }
}
