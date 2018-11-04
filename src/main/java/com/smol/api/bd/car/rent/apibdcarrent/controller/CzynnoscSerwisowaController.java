package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscSerwisowa;
import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscSerwisowaDto;
import com.smol.api.bd.car.rent.apibdcarrent.service.CzynnoscSerwisowaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/czynnosciSerwisowe")
@RestController
public class CzynnoscSerwisowaController {

    private CzynnoscSerwisowaService mCzynnoscSerwisowaService;

    @Autowired
    public CzynnoscSerwisowaController(CzynnoscSerwisowaService czynnoscSerwisowaService) {
        mCzynnoscSerwisowaService = czynnoscSerwisowaService;
    }

    @PostMapping("")
    public ResponseEntity<CzynnoscSerwisowaDto> createCzynnoscSerwisowa(@Valid @RequestBody CzynnoscSerwisowaDto czynnoscSerwisowaDto) {
        CzynnoscSerwisowa czynnoscSerwisowa = mCzynnoscSerwisowaService.createCzynnoscSerwisowa(czynnoscSerwisowaDto);
        if (czynnoscSerwisowa == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(mCzynnoscSerwisowaService.convertToDto(czynnoscSerwisowa));
    }

    @GetMapping("")
    public List<CzynnoscSerwisowaDto> getAllCzynnosciSerwisowe() {
        return mCzynnoscSerwisowaService.getAllCzynnosciSerwisowe().stream()
                .map(czynnoscSerwisowa -> mCzynnoscSerwisowaService.convertToDto(czynnoscSerwisowa))
                .collect(Collectors.toList());
    }
}
