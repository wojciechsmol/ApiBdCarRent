package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscEksploatacyjna;
import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscEksploatacyjnaDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.Pojazd;
import com.smol.api.bd.car.rent.apibdcarrent.model.Pracownik;
import com.smol.api.bd.car.rent.apibdcarrent.repository.CzynnoscEksploatacyjnaRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PojazdRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PracownikRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CzynnoscEksploatacyjnaServiceImpl implements CzynnoscEksploatacyjnaService {

    ModelMapper mModelMapper;
    PojazdRepository mPojazdRepository;
    PojazdService mPojazdService;
    PracownikRepository mPracownikRepository;
    PracownikService mPracownikService;
    CzynnoscEksploatacyjnaRepository mCzynnoscEksploatacyjnaRepository;
    EwidencjaKosztowService mEwidencjaKosztowService;

    @Autowired
    public CzynnoscEksploatacyjnaServiceImpl(ModelMapper modelMapper, PojazdRepository pojazdRepository, PojazdService pojazdService, PracownikRepository pracownikRepository, PracownikService pracownikService, CzynnoscEksploatacyjnaRepository czynnoscEksploatacyjnaRepository, EwidencjaKosztowService ewidencjaKosztowService) {
        mModelMapper = modelMapper;
        mPojazdRepository = pojazdRepository;
        mPojazdService = pojazdService;
        mPracownikRepository = pracownikRepository;
        mPracownikService = pracownikService;
        mCzynnoscEksploatacyjnaRepository = czynnoscEksploatacyjnaRepository;
        mEwidencjaKosztowService = ewidencjaKosztowService;
    }

    @Override
    public CzynnoscEksploatacyjna createCzynnoscEksploatacyjna(CzynnoscEksploatacyjnaDto czynnoscEksploatacyjnaDto) {
        CzynnoscEksploatacyjna czynnoscEksploatacyjna = convertFromDto(czynnoscEksploatacyjnaDto);
        if (czynnoscEksploatacyjna == null)
            return null;


        mEwidencjaKosztowService.createEwidencjaKosztowWithCzynnoscEksploatacyjna(czynnoscEksploatacyjna);
        return czynnoscEksploatacyjna;
    }

    @Override
    public List<CzynnoscEksploatacyjna> getAllCzynnosciEksploatacyjne() {
        List<CzynnoscEksploatacyjna> czynnosciEksploatacyjne = new ArrayList<>();
        mCzynnoscEksploatacyjnaRepository.findAll().forEach(czynnosciEksploatacyjne::add);
        return czynnosciEksploatacyjne;
    }

    @Override
    public CzynnoscEksploatacyjna convertFromDto(CzynnoscEksploatacyjnaDto czynnoscEksploatacyjnaDto) {

        CzynnoscEksploatacyjna czynnoscEksploatacyjna = mModelMapper.map(czynnoscEksploatacyjnaDto, CzynnoscEksploatacyjna.class);

        czynnoscEksploatacyjna.setRodzajCzynnosciEksploatacyjnej(CzynnoscEksploatacyjna.rodzajCzynnoscEksploatacyjnej.valueOf(czynnoscEksploatacyjnaDto.getNazwa()));


        if(!mPojazdRepository.exists(czynnoscEksploatacyjnaDto.getIdPojazdu()))
            return null;
        Pojazd pojazd = mPojazdRepository.findOne(czynnoscEksploatacyjnaDto.getIdPojazdu());
        czynnoscEksploatacyjna.setPojazd(pojazd);


        if(!mPracownikRepository.exists(czynnoscEksploatacyjnaDto.getIdPracownika()))
            return null;

        Pracownik pracownik = mPracownikRepository.findOne(czynnoscEksploatacyjnaDto.getIdPracownika());
        czynnoscEksploatacyjna.setPracownik(pracownik);

        pojazd.getCzynnosciEksploatacyjne().add(czynnoscEksploatacyjna);
        mPojazdRepository.save(pojazd);
        pracownik.getCzynnosciEksploatacyjne().add(czynnoscEksploatacyjna);
        mPracownikRepository.save(pracownik);

        mCzynnoscEksploatacyjnaRepository.save(czynnoscEksploatacyjna);

        return czynnoscEksploatacyjna;
    }

    @Override
    public CzynnoscEksploatacyjnaDto convertToDto(CzynnoscEksploatacyjna czynnoscEksploatacyjna) {

        CzynnoscEksploatacyjnaDto czynnoscEksploatacyjnaDto = mModelMapper.map(czynnoscEksploatacyjna, CzynnoscEksploatacyjnaDto.class);

        czynnoscEksploatacyjnaDto.setIdPojazdu(czynnoscEksploatacyjna.getPojazd().getId());
        czynnoscEksploatacyjnaDto.setIdPracownika(czynnoscEksploatacyjna.getPracownik().getId());
        czynnoscEksploatacyjnaDto.setNazwa(czynnoscEksploatacyjna.getRodzajCzynnosciEksploatacyjnej().toString());

        return czynnoscEksploatacyjnaDto;
    }
}
