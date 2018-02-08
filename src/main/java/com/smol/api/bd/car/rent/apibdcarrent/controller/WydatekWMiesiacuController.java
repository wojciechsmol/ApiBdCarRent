package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekWMiesiacuDto;
import com.smol.api.bd.car.rent.apibdcarrent.service.WydatekMiesiecznyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import java.util.List;

@RequestMapping("/wszystkieWydatkiWMiesiacu")
@RestController
public class WydatekWMiesiacuController {

    private WydatekMiesiecznyService mWydatekMiesiecznyService;

    @Autowired
    public WydatekWMiesiacuController(WydatekMiesiecznyService wydatekMiesiecznyService) {
        mWydatekMiesiecznyService = wydatekMiesiecznyService;
    }

    @GetMapping("")
    public List<WydatekWMiesiacuDto> getWszystkieWydatkiWMiesiac(){
        return mWydatekMiesiecznyService.getWszystkieWydatkiWMiesiacu();
    }
}
