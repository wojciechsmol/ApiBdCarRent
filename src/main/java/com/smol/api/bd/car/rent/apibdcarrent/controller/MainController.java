package com.smol.api.bd.car.rent.apibdcarrent.controller;

import com.smol.api.bd.car.rent.apibdcarrent.model.*;
import com.smol.api.bd.car.rent.apibdcarrent.repository.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import java.util.EnumSet;


@RestController
public class MainController {

    @GetMapping("/rolePracownikow")
    public EnumSet<Pracownik.Rola> getRole() {
        return Pracownik.Rola.allRola;
    }

    @GetMapping("/statusyZatrudnienia")
    public EnumSet<Pracownik.StatusZatrudnienia> getStatusy() {
        return Pracownik.StatusZatrudnienia.allStatusyZatrudnienia;
    }

    @GetMapping("/statusyWypozyczenia")
    public EnumSet<Wypozyczenie.statusyWypozyczen> getStatusyWypozyczen() {
        return Wypozyczenie.statusyWypozyczen.allStatusyWypozyczen;
    }

    @GetMapping("/statusyPojazdu")
    public EnumSet<Pojazd.statusPojazdu> getStatusyPojazdu() {
        return Pojazd.statusPojazdu.allStatusyPojazdu;
    }

    @GetMapping("/nadwozia")
    public EnumSet<Model.typNadwozia> getAllNadwozia() {
        return Model.typNadwozia.allTypyNadwozia;
    }

    @GetMapping("/listaCzynnosciSerwisowych")
    public EnumSet<CzynnoscSerwisowa.rodzajCzynnosciSerwisowej> getAllCzynnosciSerwisowe() {
        return CzynnoscSerwisowa.rodzajCzynnosciSerwisowej.allCzynnosciSerwisowe;
    }

    @GetMapping("/listaCzynnosciEksploatacyjnych")
    public EnumSet<CzynnoscEksploatacyjna.rodzajCzynnoscEksploatacyjnej> getAllCzynnosciEksploatacyjne() {
        return CzynnoscEksploatacyjna.rodzajCzynnoscEksploatacyjnej.allCzynnosciEksploatacyjne;
    }


}
