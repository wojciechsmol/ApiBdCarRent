package com.smol.api.bd.car.rent.apibdcarrent.service;

import com.smol.api.bd.car.rent.apibdcarrent.model.Pracownik;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private PracownikRepository pracownikRepository;

    @Autowired
    public DataLoader(PracownikRepository pracownikRepository) {
        this.pracownikRepository = pracownikRepository;
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
    }
}
