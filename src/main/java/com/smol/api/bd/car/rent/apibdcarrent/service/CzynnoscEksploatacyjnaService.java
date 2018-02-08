package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscEksploatacyjna;
import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscEksploatacyjnaDto;

import java.util.List;

public interface CzynnoscEksploatacyjnaService {

    CzynnoscEksploatacyjna createCzynnoscEksploatacyjna(CzynnoscEksploatacyjnaDto czynnoscEksploatacyjnaDto);

    List<CzynnoscEksploatacyjna> getAllCzynnosciEksploatacyjne();

    CzynnoscEksploatacyjna convertFromDto(CzynnoscEksploatacyjnaDto czynnoscEksploatacyjnaDto);

    CzynnoscEksploatacyjnaDto convertToDto(CzynnoscEksploatacyjna czynnoscEksploatacyjna);

}
