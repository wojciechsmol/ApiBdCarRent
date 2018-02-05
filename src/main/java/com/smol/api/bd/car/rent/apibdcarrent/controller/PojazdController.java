package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.*;
import com.smol.api.bd.car.rent.apibdcarrent.service.PojazdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("")
    public ResponseEntity<PojazdDto> createPojazd(@Valid @RequestBody PojazdDto pojazdDto) {
        return ResponseEntity.ok(mPojazdService.convertToDto(mPojazdService.createPojazd(pojazdDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PojazdDto> getPojazd(@PathVariable(value = "id") Long pojazdId){
        Pojazd pojazd = mPojazdService.getPojazd(pojazdId);
        if (pojazd == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(mPojazdService.convertToDto(pojazd));

    }

    @PatchMapping("/{id}")
    public ResponseEntity<PojazdDto> updatePojazd(@PathVariable(value = "id") Long pojazdId,
                                                        @Valid @RequestBody PojazdDto pojazdDetails) {

        Pojazd pojazd = mPojazdService.updatePojazd(pojazdId, pojazdDetails);
        if(pojazd == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(mPojazdService.convertToDto(pojazd));
    }

}
