package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.EwidencjaKosztow;
import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekMiesiecznyDto;
import com.smol.api.bd.car.rent.apibdcarrent.model.WydatekWMiesiacuDto;
import com.smol.api.bd.car.rent.apibdcarrent.repository.EwidencjaKosztowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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
    public List<WydatekWMiesiacuDto> getWszystkieWydatkiWMiesiacu() {

        List<EwidencjaKosztow> koszty = new ArrayList<>();
        mEwidencjaKosztowRepository.findAll().forEach(koszty::add);

        List<WydatekWMiesiacuDto> wszystkieWydatki = new ArrayList<>();
        int index;
        List<Integer> yearsToHandle = new ArrayList<>();

        for (EwidencjaKosztow koszt : koszty) {

            index = getWydatekWMiesiacuIndex(koszt.getData().getYear(), getMonthFromInt(koszt.getData().getMonthValue()), wszystkieWydatki);
            if (index >= 0) {
                WydatekWMiesiacuDto wydatekWMiesiacu = wszystkieWydatki.get(index);
                wydatekWMiesiacu.setCena(wydatekWMiesiacu.getCena() + koszt.getCena());
            } else if (index == -1) {
                WydatekWMiesiacuDto wydatekWMiesiacu = new WydatekWMiesiacuDto(koszt.getData().getYear(), getMonthFromInt(koszt.getData().getMonthValue()), koszt.getCena(), koszt.getData());
                wszystkieWydatki.add(wydatekWMiesiacu);

                if (!yearsToHandle.contains(wydatekWMiesiacu.getRok()))
                    yearsToHandle.add(wydatekWMiesiacu.getRok());
            }
        }

        for (int year : yearsToHandle){
            for(int i=1; i <=12; i++){
                int indexHelp = getWydatekWMiesiacuIndex(year, getMonthFromInt(i), wszystkieWydatki);
                if (indexHelp == -1){
                    wszystkieWydatki.add(new WydatekWMiesiacuDto(year, getMonthFromInt(i), 0, LocalDate.of(year, i, 1)));
                }
            }
        }


            wszystkieWydatki.sort(Comparator.comparing(w -> w.getData()));

        return wszystkieWydatki;
    }

    @Override
    public int getWydatekWMiesiacuIndex(int rok, String miesiac, List<WydatekWMiesiacuDto> wszystkieWydatki) {
        for (WydatekWMiesiacuDto wydatek : wszystkieWydatki) {
            if (wydatek.getRok() == rok && wydatek.getMiesiac().equals(miesiac))
                return wszystkieWydatki.indexOf(wydatek);
        }
        return -1;
    }




    @Override
    public String getMonthFromInt(int miesiac) {
        switch (miesiac) {
            case 1:
                return "Styczeń";
            case 2:
                return "Luty";
            case 3:
                return "Marzec";
            case 4:
                return "Kwiecień";
            case 5:
                return "Maj";
            case 6:
                return "Czerwiec";
            case 7:
                return "Lipiec";
            case 8:
                return "Sierpień";
            case 9:
                return "Wrzesień";
            case 10:
                return "Październik";
            case 11:
                return "Listopad";
            case 12:
                return "Grudzień";
        }
        return "";
    }


}
