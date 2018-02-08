package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscSerwisowa;
import com.smol.api.bd.car.rent.apibdcarrent.model.CzynnoscSerwisowaDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.Pojazd;
import com.smol.api.bd.car.rent.apibdcarrent.model.Pracownik;
import com.smol.api.bd.car.rent.apibdcarrent.repository.CzynnoscEksploatacyjnaRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.CzynnoscSerwisowaRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PojazdRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PracownikRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CzynnoscSerwisowaServiceImpl implements CzynnoscSerwisowaService {

    private ModelMapper mModelMapper;
    private PojazdRepository mPojazdRepository;
    private PojazdService mPojazdService;
    private PracownikRepository mPracownikRepository;
    private PracownikService mPracownikService;
    private CzynnoscSerwisowaRepository mCzynnoscSerwisowaRepository;
    private EwidencjaKosztowService mEwidencjaKosztowService;

    @Autowired
    public CzynnoscSerwisowaServiceImpl(ModelMapper modelMapper, PojazdRepository pojazdRepository, PojazdService pojazdService, PracownikRepository pracownikRepository, PracownikService pracownikService, CzynnoscSerwisowaRepository czynnoscSerwisowaRepository, EwidencjaKosztowService ewidencjaKosztowService) {
        mModelMapper = modelMapper;
        mPojazdRepository = pojazdRepository;
        mPojazdService = pojazdService;
        mPracownikRepository = pracownikRepository;
        mPracownikService = pracownikService;
        mCzynnoscSerwisowaRepository = czynnoscSerwisowaRepository;
        mEwidencjaKosztowService = ewidencjaKosztowService;
    }

    @Override
    public CzynnoscSerwisowa createCzynnoscSerwisowa(CzynnoscSerwisowaDto czynnoscSerwisowaDto) {

        CzynnoscSerwisowa czynnoscSerwisowa = convertFromDto(czynnoscSerwisowaDto);
        if (czynnoscSerwisowa == null)
            return null;

        mEwidencjaKosztowService.createEwidencjaKosztowWithCzynnoscSerwisowa(czynnoscSerwisowa);
        return czynnoscSerwisowa;

    }

    @Override
    public List<CzynnoscSerwisowa> getAllCzynnosciSerwisowe() {
        List<CzynnoscSerwisowa> czynnosciSerwisowe = new ArrayList<>();
        mCzynnoscSerwisowaRepository.findAll().forEach(czynnosciSerwisowe::add);
        return czynnosciSerwisowe;
    }

    @Override
    public CzynnoscSerwisowa convertFromDto(CzynnoscSerwisowaDto czynnoscSerwisowaDto) {
        CzynnoscSerwisowa czynnoscSerwisowa = mModelMapper.map(czynnoscSerwisowaDto, CzynnoscSerwisowa.class);

        czynnoscSerwisowa.setRodzajCzynnosciSerwisowej(CzynnoscSerwisowa.rodzajCzynnosciSerwisowej.valueOf(czynnoscSerwisowaDto.getNazwa()));

        if (!mPojazdRepository.exists(czynnoscSerwisowaDto.getIdPojazdu()))
            return null;

        Pojazd pojazd = mPojazdRepository.findOne(czynnoscSerwisowaDto.getIdPojazdu());
        czynnoscSerwisowa.setPojazd(pojazd);

        pojazd.getCzynnosciSerwisowe().add(czynnoscSerwisowa);
        mPojazdRepository.save(pojazd);

        mCzynnoscSerwisowaRepository.save(czynnoscSerwisowa);

        return czynnoscSerwisowa;
    }

    @Override
    public CzynnoscSerwisowaDto convertToDto(CzynnoscSerwisowa czynnoscSerwisowa) {

        CzynnoscSerwisowaDto czynnoscSerwisowaDto = mModelMapper.map(czynnoscSerwisowa, CzynnoscSerwisowaDto.class);

        czynnoscSerwisowaDto.setIdPojazdu(czynnoscSerwisowa.getPojazd().getId());
        czynnoscSerwisowaDto.setNazwa(czynnoscSerwisowa.getRodzajCzynnosciSerwisowej().toString());

        return czynnoscSerwisowaDto;
    }
}
