package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.EwidencjaKosztow;
import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekKierowcyDto;
import com.smol.api.bd.car.rent.apibdcarrent.repository.EwidencjaKosztowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WydatekKierowcyServiceImpl implements WydatekKierowcyService {

    private EwidencjaKosztowRepository mEwidencjaKosztowRepository;

    @Autowired
    public WydatekKierowcyServiceImpl(EwidencjaKosztowRepository ewidencjaKosztowRepository) {
        mEwidencjaKosztowRepository = ewidencjaKosztowRepository;
    }

    @Override
    public WydatekKierowcyDto getWydatekKierowcy(Long idKierowcy) {
        int wydatki = 0;

        List<EwidencjaKosztow> koszty = new ArrayList<>();
        mEwidencjaKosztowRepository.findAll().forEach(koszty::add);

        for (EwidencjaKosztow koszt : koszty) {
            if (koszt.getIdKierowcy() != null){
                if (koszt.getIdKierowcy() == idKierowcy.intValue())
                    wydatki += koszt.getCena();
            }
        }

        return new WydatekKierowcyDto(idKierowcy, wydatki);
    }
}
