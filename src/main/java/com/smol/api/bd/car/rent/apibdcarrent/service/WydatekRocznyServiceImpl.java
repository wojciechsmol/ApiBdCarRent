package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.EwidencjaKosztow;
import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekRocznyDto;
import com.smol.api.bd.car.rent.apibdcarrent.repository.EwidencjaKosztowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class WydatekRocznyServiceImpl implements WydatekRocznyService {

    private EwidencjaKosztowRepository mEwidencjaKosztowRepository;

    @Autowired
    public WydatekRocznyServiceImpl(EwidencjaKosztowRepository ewidencjaKosztowRepository) {
        mEwidencjaKosztowRepository = ewidencjaKosztowRepository;
    }

    @Override
    public WydatekRocznyDto getWydatekRoczny(int rok, Long idPojazdu) {

        List<EwidencjaKosztow> koszty = new ArrayList<>();
        mEwidencjaKosztowRepository.findAll().forEach(koszty::add);

        List<WydatekDto> wydatki = new ArrayList<>();
        WydatekDto tankowanie = new WydatekDto("TANKOWANIE", 0);
        WydatekDto dolaniePlynuDoSpryskiwaczy = new WydatekDto("DOLANIE_PŁYNU_DO_SPRYSKIWACZY", 0);
        WydatekDto dolanieOlejuSilnikowego = new WydatekDto("DOLANIE_OLEJU_SILNIKOWEGO", 0);
        WydatekDto wymianaRozrzadu = new WydatekDto("WYMIANA_ROZRZĄDU", 0);
        WydatekDto naprawyLakiernicze = new WydatekDto("NAPRAWY_LAKIERNICZE", 0);
        WydatekDto wymianaSilnika = new WydatekDto("WYMIANA_SILNIKA", 0);

        for (EwidencjaKosztow koszt : koszty) {
            String wydatekType = koszt.getNazwaCzynnosci();

            if (koszt.getData().getYear() == rok && koszt.getPojazd().getId() == idPojazdu) {

                switch (wydatekType) {
                    case "TANKOWANIE":
                        tankowanie.setCena(tankowanie.getCena() + koszt.getCena());
                        break;
                    case "DOLANIE_PLYNU_DO_SPRYSKIWACZY":
                        dolaniePlynuDoSpryskiwaczy.setCena(dolaniePlynuDoSpryskiwaczy.getCena() + koszt.getCena());
                        break;
                    case "DOLANIE_OLEJU_SILNIKOWEGO":
                        dolanieOlejuSilnikowego.setCena(dolanieOlejuSilnikowego.getCena() + koszt.getCena());
                        break;
                    case "WYMIANA_ROZRZADU":
                        wymianaRozrzadu.setCena(wymianaRozrzadu.getCena() + koszt.getCena());
                        break;
                    case "NAPRAWY_LAKIERNICZE":
                        naprawyLakiernicze.setCena(naprawyLakiernicze.getCena() + koszt.getCena());
                        break;
                    case "WYMIANA_SILNIKA":
                        wymianaSilnika.setCena(wymianaSilnika.getCena() + koszt.getCena());
                        break;
                }
            }
        }

        if (tankowanie.getCena() > 0)
            wydatki.add(tankowanie);
        if (dolaniePlynuDoSpryskiwaczy.getCena() > 0)
            wydatki.add(dolaniePlynuDoSpryskiwaczy);
        if (dolanieOlejuSilnikowego.getCena() > 0)
            wydatki.add(dolanieOlejuSilnikowego);
        if (wymianaRozrzadu.getCena() > 0)
            wydatki.add(wymianaRozrzadu);
        if (naprawyLakiernicze.getCena() > 0)
            wydatki.add(naprawyLakiernicze);
        if (wymianaSilnika.getCena() > 0)
            wydatki.add(wymianaSilnika);

        return new WydatekRocznyDto(idPojazdu, rok, wydatki);
    }
}
