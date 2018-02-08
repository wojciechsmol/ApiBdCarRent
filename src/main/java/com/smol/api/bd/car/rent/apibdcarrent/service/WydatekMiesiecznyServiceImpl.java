package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.EwidencjaKosztow;
import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekMiesiecznyDto;
import com.smol.api.bd.car.rent.apibdcarrent.repository.EwidencjaKosztowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WydatekMiesiecznyServiceImpl implements WydatekMiesiecznyService {

    private EwidencjaKosztowRepository mEwidencjaKosztowRepository;

    @Autowired
    public WydatekMiesiecznyServiceImpl(EwidencjaKosztowRepository ewidencjaKosztowRepository) {
        mEwidencjaKosztowRepository = ewidencjaKosztowRepository;
    }

    @Override
    public WydatekMiesiecznyDto getWydatekMiesieczny(int rok, int miesiac, Long idPojazdu) {

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

            if (koszt.getData().getYear() == rok && koszt.getData().getMonthValue() == miesiac && koszt.getPojazd().getId() == idPojazdu) {

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

        return new WydatekMiesiecznyDto(idPojazdu, getMonthFromInt(miesiac), wydatki);
    }


    @Override
    public String getMonthFromInt(int miesiac) {
        switch (miesiac) {
            case 1:
                return "styczeń";
            case 2:
                return "luty";
            case 3:
                return "marzec";
            case 4:
                return "kwiecień";
            case 5:
                return "maj";
            case 6:
                return "czerwiec";
            case 7:
                return "lipiec";
            case 8:
                return "sierpień";
            case 9:
                return "wrzesień";
            case 10:
                return "październik";
            case 11:
                return "listopad";
            case 12:
                return "grudzień";
        }
        return "";
    }
}
