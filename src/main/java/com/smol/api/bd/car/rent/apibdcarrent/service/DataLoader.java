package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.*;
import com.smol.api.bd.car.rent.apibdcarrent.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class DataLoader implements ApplicationRunner {

    private PracownikRepository pracownikRepository;
    private MarkaRepository mMarkaRepository;
    private ModelRepository mModelRepository;
    private PojazdRepository mPojazdRepository;
    private WypozyczenieRepository mWypozyczenieRepository;
    private OpiekaRepository mOpiekaRepository;

    public DataLoader(PracownikRepository pracownikRepository, MarkaRepository markaRepository, ModelRepository modelRepository, PojazdRepository pojazdRepository, WypozyczenieRepository wypozyczenieRepository, OpiekaRepository opiekaRepository) {
        this.pracownikRepository = pracownikRepository;
        mMarkaRepository = markaRepository;
        mModelRepository = modelRepository;
        mPojazdRepository = pojazdRepository;
        mWypozyczenieRepository = wypozyczenieRepository;
        mOpiekaRepository = opiekaRepository;
    }

    public void run(ApplicationArguments args) {
        loadData();
    }

    private void loadData(){

        Pracownik prac1 = new Pracownik("18121115224", "Krzysiek", "Kowalski", java.time.LocalDate.of(1971, 10, 4), Pracownik.StatusZatrudnienia.PRACUJE, Pracownik.Rola.OPIEKUN);
        pracownikRepository.save(prac1);

        Pracownik prac2 = new Pracownik("95063468245", "Jacek", "Nowak", java.time.LocalDate.of(1994, 7, 3), Pracownik.StatusZatrudnienia.PRACUJE, Pracownik.Rola.KIEROWCA);
        pracownikRepository.save(prac2);

        Pracownik prac3 = new Pracownik("74859375847", "Piotr", "Kłosowski", java.time.LocalDate.of(1923, 8, 2),  Pracownik.StatusZatrudnienia.PRACUJE, Pracownik.Rola.MENADŻER);
        pracownikRepository.save(prac3);


        Marka opel = new Marka("Opel");
        mMarkaRepository.save(opel);

        Model corsa = new Model("Corsa", 5, 2006, Model.typNadwozia.HATCHBACK, opel);
        mModelRepository.save(corsa);

        Pojazd pojazd1 = new Pojazd("SLU34AW", 102987, Pojazd.statusPojazdu.SPRAWNY, corsa);
        mPojazdRepository.save(pojazd1);

        Opieka opieka1 = new Opieka(prac1, pojazd1);
        mOpiekaRepository.save(opieka1);

        Pojazd corsa1 = mPojazdRepository.findOne(pojazd1.getId());
        corsa1.setOpieka(opieka1);
        mPojazdRepository.save(corsa1);

        Pojazd pojazd2 = new Pojazd("DFE34", 3344, Pojazd.statusPojazdu.SPRAWNY, corsa);
        mPojazdRepository.save(pojazd2);

        Opieka opieka2 = new Opieka(prac3, pojazd2);
        mOpiekaRepository.save(opieka2);

        corsa1 = mPojazdRepository.findOne(pojazd2.getId());
        corsa1.setOpieka(opieka2);
        mPojazdRepository.save(corsa1);

        Pracownik pracJeden = pracownikRepository.findOne(prac1.getId());
        pracJeden.setOpieki(new ArrayList<>());
        pracJeden.getOpieki().add(opieka1);
        pracownikRepository.save(pracJeden);

        Pracownik pracTrzy = pracownikRepository.findOne(prac3.getId());
        pracTrzy.setOpieki(new ArrayList<>());
        pracTrzy.getOpieki().add(opieka2);
        pracownikRepository.save(pracTrzy);

        Wypozyczenie wyp1 = new Wypozyczenie(LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), 129000, 129034, prac1, pojazd1, Wypozyczenie.statusyWypozyczen.ZAKOŃCZONE);
        mWypozyczenieRepository.save(wyp1);


    }
}
