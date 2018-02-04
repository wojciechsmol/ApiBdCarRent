package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.*;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PojazdRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PojazdServiceImpl implements PojazdService {

    PojazdRepository mPojazdRepository;
    MarkaService mMarkaService;
    ModelService mModelService;
    ModelMapper mModelMapper;

    @Autowired
    public PojazdServiceImpl(PojazdRepository pojazdRepository, MarkaService markaService, ModelService modelService, ModelMapper modelMapper) {
        mPojazdRepository = pojazdRepository;
        mMarkaService = markaService;
        mModelService = modelService;
        mModelMapper = modelMapper;
    }

    @Override
    public List<Pojazd> getAllPojazdy() {
        List<Pojazd> pojazdy = new ArrayList<>();
        mPojazdRepository.findAll().forEach(pojazdy::add);
        return pojazdy;
    }

    @Override
    public List<Pojazd> getAllAvailablePojazdy(String from, String to) {
        //Formatter for the input strings
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");

        //Converting Strings to time
        LocalDateTime fromTime = LocalDateTime.parse(from, formatter);
        LocalDateTime toTime = LocalDateTime.parse(to, formatter);

        //Save all the pojazdy to the list
        List<Pojazd> availablePojazdy = getAllPojazdy();

        //if toTime is before current time, then return empty list
        if(toTime.isBefore(LocalDateTime.now()))
            return availablePojazdy;

        boolean isAvailable;

        //check all the pojazdy
        for (Iterator<Pojazd> i = availablePojazdy.iterator(); i.hasNext();) {
            Pojazd pojazd = i.next();
            isAvailable = true;

                //check if at the given time it's taken
                if (pojazd.isTaken(fromTime, toTime)) {
                    isAvailable = false;
                }

            //if it's booked, then remove it from the list
            if(!isAvailable)
                i.remove();
        }

        return availablePojazdy;
    }

    @Override
    public PojazdDto convertToDto(Pojazd pojazd) {

        PojazdDto pojazdDto = mModelMapper.map(pojazd, PojazdDto.class);

        pojazdDto.setMarka(mMarkaService.convertToDto(pojazd.getModel().getMarka()));
        pojazdDto.setModel(mModelService.convertToDto(pojazd.getModel()));
        pojazdDto.setOpiekun(pojazd.getOpieka().getPracownik().getImie() + " " + pojazd.getOpieka().getPracownik().getNazwisko());

        return pojazdDto;
    }
}
