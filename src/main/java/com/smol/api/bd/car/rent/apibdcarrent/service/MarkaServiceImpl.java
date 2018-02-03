package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Marka;
import com.smol.api.bd.car.rent.apibdcarrent.model.MarkaDto;
import com.smol.api.bd.car.rent.apibdcarrent.repository.MarkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkaServiceImpl implements MarkaService{

   private MarkaRepository mMarkaRepository;

   @Autowired

    public MarkaServiceImpl(MarkaRepository markaRepository) {
        mMarkaRepository = markaRepository;
    }

    @Override
    public MarkaDto convertToDto(Marka marka) {
        return new MarkaDto(marka.getOpis());
    }
}
