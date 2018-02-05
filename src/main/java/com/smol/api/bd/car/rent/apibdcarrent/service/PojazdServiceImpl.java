package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.*;
import com.smol.api.bd.car.rent.apibdcarrent.repository.*;
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
    PracownikRepository mPracownikRepository;
    ModelService mModelService;
    ModelMapper mModelMapper;
    OpiekaRepository mOpiekaRepository;
    ModelRepository mModelRepository;
    MarkaRepository mMarkaRepository;

    @Autowired
    public PojazdServiceImpl(PojazdRepository pojazdRepository, MarkaService markaService, PracownikRepository pracownikRepository, ModelService modelService, ModelMapper modelMapper, OpiekaRepository opiekaRepository, ModelRepository modelRepository, MarkaRepository markaRepository) {
        mPojazdRepository = pojazdRepository;
        mMarkaService = markaService;
        mPracownikRepository = pracownikRepository;
        mModelService = modelService;
        mModelMapper = modelMapper;
        mOpiekaRepository = opiekaRepository;
        mModelRepository = modelRepository;
        mMarkaRepository = markaRepository;
    }

    @Override
    public List<Pojazd> getAllPojazdy() {
        List<Pojazd> pojazdy = new ArrayList<>();
        Pojazd pojazd = mPojazdRepository.findOne(Long.parseLong("2"));
        Model model = mModelRepository.findOne(Long.valueOf(1));

        mPojazdRepository.findAll().forEach(pojazdy::add);
        return pojazdy;

    }

    @Override
    public List<Pojazd> getAllAvailablePojazdy(String from, String to) {
        //Formatter for the input strings
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm");

        //Converting Strings to time
        LocalDateTime fromTime = LocalDateTime.parse(from, formatter);
        LocalDateTime toTime = LocalDateTime.parse(to, formatter);

        //Save all the pojazdy to the list
        List<Pojazd> availablePojazdy = new ArrayList<>();

        //if toTime is before current time, then return empty list
        if (toTime.isBefore(LocalDateTime.now()))
            return availablePojazdy;

        availablePojazdy = getAllPojazdy();
        boolean isAvailable;

        //check all the pojazdy
        for (Iterator<Pojazd> i = availablePojazdy.iterator(); i.hasNext(); ) {
            Pojazd pojazd = i.next();
            isAvailable = true;

            //check if at the given time it's taken
            if (pojazd.isTaken(fromTime, toTime))
                isAvailable = false;
            if (!pojazd.isAvailable())
                isAvailable = false;

            //if it's booked, then remove it from the list
            if (!isAvailable)
                i.remove();
        }

        return availablePojazdy;
    }

    @Override
    public Pojazd createPojazd(PojazdDto pojazdDto) {

        Pojazd pojazd = convertFromDto(pojazdDto);
        return pojazd;
    }

    @Override
    public Pojazd getPojazd(Long pojazdId) {
        Pojazd pojazd = mPojazdRepository.findOne(pojazdId);
        if (pojazd == null){
            return null;
        }

        return pojazd;
    }

    @Override
    public PojazdDto convertToDto(Pojazd pojazd) {

        PojazdDto pojazdDto = mModelMapper.map(pojazd, PojazdDto.class);

        pojazdDto.setMarka(mMarkaService.convertToDto(pojazd.getModel().getMarka()));
        pojazdDto.setModel(mModelService.convertToDto(pojazd.getModel()));
        pojazdDto.setOpiekun(pojazd.getOpieka().getPracownik().getImie() + " " + pojazd.getOpieka().getPracownik().getNazwisko());
        pojazdDto.setIdOpiekuna(pojazd.getOpieka().getPracownik().getId());

        return pojazdDto;
    }

    @Override
    public Pojazd convertFromDto(PojazdDto pojazdDto) {

        Pojazd pojazd = mModelMapper.map(pojazdDto, Pojazd.class);

        pojazd.setModel(mModelService.convertFromDto(pojazdDto.getModel(), pojazdDto));

        pojazd.setEwidencjeKosztow(new ArrayList<>());
        pojazd.setCzynnosciEksploatacyjne(new ArrayList<>());
        pojazd.setCzynnosciSerwisowe(new ArrayList<>());
        pojazd.setWypozyczenia(new ArrayList<>());

        if (pojazd.getModel().getPojazdy() == null)
        pojazd.getModel().setPojazdy(new ArrayList<>());

        pojazd.getModel().getPojazdy().add(pojazd);
        mPojazdRepository.save(pojazd);


        if(pojazdDto.getIdOpiekuna() != null) {
            if (mPracownikRepository.exists(pojazdDto.getIdOpiekuna())) {
                Opieka opieka = new Opieka(mPracownikRepository.findOne(pojazdDto.getIdOpiekuna()), pojazd);
                mOpiekaRepository.save(opieka);
                pojazd.setOpieka(opieka);

            }
        }
        mPojazdRepository.save(pojazd);
        return pojazd;
    }

}
