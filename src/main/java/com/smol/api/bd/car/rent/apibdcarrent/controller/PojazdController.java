package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.Pojazd;
import com.smol.api.bd.car.rent.apibdcarrent.model.PojazdDto;
import com.smol.api.bd.car.rent.apibdcarrent.service.PojazdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/pojazdy")
@RestController
public class PojazdController {

    private PojazdService mPojazdService;

    @Autowired

    public PojazdController(PojazdService pojazdService) {
        mPojazdService = pojazdService;
    }

    @GetMapping("")
    public List<PojazdDto> getAllPojazdy(){
        return mPojazdService.getAllPojazdy().stream()
                .map(pojazd -> mPojazdService.convertToDto(pojazd))
                .collect(Collectors.toList());
    }

    @GetMapping("/dostepne")
    public List<PojazdDto> getAllAvailablePojazdy(@RequestParam("od") String from,
                                                  @RequestParam("do") String to){
        return mPojazdService.getAllAvailablePojazdy(from, to).stream()
                .map(pojazd -> mPojazdService.convertToDto(pojazd))
                .collect(Collectors.toList());
    }

}
