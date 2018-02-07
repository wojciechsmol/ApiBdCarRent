package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.*;
import com.smol.api.bd.car.rent.apibdcarrent.repository.EwidencjaKosztowRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PojazdRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EwidencjaKosztowServiceImpl implements EwidencjaKosztowService {

    EwidencjaKosztowRepository mEwidencjaKosztowRepository;
    PojazdRepository mPojazdRepository;
    PracownikRepository mPracownikRepository;

    @Autowired
    public EwidencjaKosztowServiceImpl(EwidencjaKosztowRepository ewidencjaKosztowRepository, PojazdRepository pojazdRepository, PracownikRepository pracownikRepository) {
        mEwidencjaKosztowRepository = ewidencjaKosztowRepository;
        mPojazdRepository = pojazdRepository;
        mPracownikRepository = pracownikRepository;
    }

    @Override
    public boolean createEwidencjaKosztowWithCzynnoscEksploatacyjna(CzynnoscEksploatacyjna czynnoscEksploatacyjna) {

        EwidencjaKosztow ewidencjaKosztow = new EwidencjaKosztow(czynnoscEksploatacyjna.getData(), czynnoscEksploatacyjna.getCena(), czynnoscEksploatacyjna.getPojazd(), czynnoscEksploatacyjna.getPracownik().getId(), czynnoscEksploatacyjna.getRodzajCzynnosciEksploatacyjnej().toString());
        if (ewidencjaKosztow != null) {
            Pojazd pojazd = czynnoscEksploatacyjna.getPojazd();
            pojazd.getEwidencjeKosztow().add(ewidencjaKosztow);
            mPojazdRepository.save(pojazd);
            mEwidencjaKosztowRepository.save(ewidencjaKosztow);
            return true;
        }
        return false;
    }

    @Override
    public boolean createEwidencjaKosztowWithCzynnoscSerwisowa(CzynnoscSerwisowa czynnoscSerwisowa) {
        EwidencjaKosztow ewidencjaKosztow = new EwidencjaKosztow(czynnoscSerwisowa.getData(), czynnoscSerwisowa.getCena(), czynnoscSerwisowa.getPojazd(), null, czynnoscSerwisowa.getRodzajCzynnosciSerwisowej().toString());

        if(ewidencjaKosztow != null) {
            Pojazd pojazd = czynnoscSerwisowa.getPojazd();
            pojazd.getEwidencjeKosztow().add(ewidencjaKosztow);
            mPojazdRepository.save(pojazd);
            mEwidencjaKosztowRepository.save(ewidencjaKosztow);
            return true;
        }
        return false;
    }
}
