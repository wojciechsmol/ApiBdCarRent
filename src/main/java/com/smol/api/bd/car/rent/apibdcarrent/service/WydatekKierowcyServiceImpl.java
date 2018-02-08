package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.EwidencjaKosztow;
import com.smol.api.bd.car.rent.apibdcarrent.model.Pracownik;
import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekKierowcyDto;
import com.smol.api.bd.car.rent.apibdcarrent.repository.EwidencjaKosztowRepository;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class WydatekKierowcyServiceImpl implements WydatekKierowcyService {

    private EwidencjaKosztowRepository mEwidencjaKosztowRepository;
    private PracownikRepository mPracownikRepository;

    @Autowired
    public WydatekKierowcyServiceImpl(EwidencjaKosztowRepository ewidencjaKosztowRepository, PracownikRepository pracownikRepository) {
        mEwidencjaKosztowRepository = ewidencjaKosztowRepository;
        mPracownikRepository = pracownikRepository;
    }

    @Override
    public WydatekKierowcyDto getWydatekKierowcy(Long idKierowcy) {
        int wydatki = 0;

        List<EwidencjaKosztow> koszty = new ArrayList<>();
        mEwidencjaKosztowRepository.findAll().forEach(koszty::add);

        for (EwidencjaKosztow koszt : koszty) {
            if (koszt.getIdKierowcy() != null) {
                if (koszt.getIdKierowcy() == idKierowcy.intValue())
                    wydatki += koszt.getCena();
            }
        }

        return new WydatekKierowcyDto(idKierowcy, wydatki);
    }

    @Override
    public List<WydatekKierowcyDto> getAllWydatkiKierowcy() {

        int wydatki = 0;

        List<Pracownik> pracownicy = new ArrayList<>();
        mPracownikRepository.findAll().forEach(pracownicy::add);

        List<WydatekKierowcyDto> wydatkiKierowcy = new ArrayList<>();

        for (Pracownik pracownik : pracownicy) {

            if (pracownik.getRola() == Pracownik.Rola.KIEROWCA)
            wydatkiKierowcy.add(getWydatekKierowcy(pracownik.getId()));
        }

        wydatkiKierowcy.sort(Comparator.comparing(w -> w.getIdKierowcy()));

        return wydatkiKierowcy;
    }
}
