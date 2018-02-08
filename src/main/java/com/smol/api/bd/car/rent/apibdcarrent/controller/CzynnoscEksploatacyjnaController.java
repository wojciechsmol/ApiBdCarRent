package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscEksploatacyjna;
import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscEksploatacyjnaDto;
import com.smol.api.bd.car.rent.apibdcarrent.service.CzynnoscEksploatacyjnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/czynnosciEksploatacyjne")
@RestController
public class CzynnoscEksploatacyjnaController {

    private CzynnoscEksploatacyjnaService mCzynnoscEksploatacyjnaService;

    @Autowired
    public CzynnoscEksploatacyjnaController(CzynnoscEksploatacyjnaService czynnoscEksploatacyjnaService) {
        mCzynnoscEksploatacyjnaService = czynnoscEksploatacyjnaService;
    }

    @PostMapping("")
    public ResponseEntity<CzynnoscEksploatacyjnaDto> createCzynnoscEksploatacyjna(@Valid @RequestBody CzynnoscEksploatacyjnaDto czynnoscEksploatacyjnaDto) {
        CzynnoscEksploatacyjna czynnoscEksploatacyjna = mCzynnoscEksploatacyjnaService.createCzynnoscEksploatacyjna(czynnoscEksploatacyjnaDto);
        if (czynnoscEksploatacyjna == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mCzynnoscEksploatacyjnaService.convertToDto(czynnoscEksploatacyjna));
    }

    @GetMapping("")
    public List<CzynnoscEksploatacyjnaDto> getAllCzynnosciEksploatacyjne() {
        return mCzynnoscEksploatacyjnaService.getAllCzynnosciEksploatacyjne().stream()
                .map(czynnoscEksploatacyjna -> mCzynnoscEksploatacyjnaService.convertToDto(czynnoscEksploatacyjna))
                .collect(Collectors.toList());
    }
}
