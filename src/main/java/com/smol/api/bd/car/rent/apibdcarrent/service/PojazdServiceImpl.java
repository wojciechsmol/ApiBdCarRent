package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Marka;
import com.smol.api.bd.car.rent.apibdcarrent.model.Pojazd;
import com.smol.api.bd.car.rent.apibdcarrent.model.PojazdDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.Wypozyczenie;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PojazdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PojazdServiceImpl implements PojazdService{

    PojazdRepository mPojazdRepository;
    MarkaService mMarkaService;
    ModelService mModelService;

    @Autowired
    public PojazdServiceImpl(PojazdRepository pojazdRepository, MarkaService markaService, ModelService modelService) {
        mPojazdRepository = pojazdRepository;
        mMarkaService = markaService;
        mModelService = modelService;
    }

    @Override
    public List<Pojazd> getAllPojazdy() {
        List<Pojazd> pojazdy = new ArrayList<>();
        mPojazdRepository.findAll().forEach(pojazdy::add);
        return pojazdy;
    }

    @Override
    public PojazdDto convertToDto(Pojazd pojazd){
        return new PojazdDto(pojazd.getId(),
                pojazd.getOpieka().getPracownik().getImie() + " " + pojazd.getOpieka().getPracownik().getNazwisko(),
                pojazd.getNrRej(),
                pojazd.getPrzebieg(),
                pojazd.getStatus(),
                mMarkaService.convertToDto(pojazd.getModel().getMarka()),
                mModelService.convertToDto(pojazd.getModel()));
    }
}
