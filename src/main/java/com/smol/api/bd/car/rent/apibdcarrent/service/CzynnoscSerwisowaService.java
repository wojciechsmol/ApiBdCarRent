package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscEksploatacyjnaDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscSerwisowa;
import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscSerwisowaDto;

import java.util.List;

public interface CzynnoscSerwisowaService {

    CzynnoscSerwisowa createCzynnoscSerwisowa(CzynnoscSerwisowaDto czynnoscSerwisowaDto);
    List<CzynnoscSerwisowa> getAllCzynnosciSerwisowe();
    CzynnoscSerwisowa convertFromDto(CzynnoscSerwisowaDto czynnoscSerwisowaDto);
    CzynnoscSerwisowaDto convertToDto(CzynnoscSerwisowa czynnoscSerwisowa);


}
