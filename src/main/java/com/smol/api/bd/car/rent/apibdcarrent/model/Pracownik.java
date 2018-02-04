package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pracownik {

    //ENUM TYPE of StatusZatrudnienia:
    public enum StatusZatrudnienia {
        PRACUJE, NIE_PRACUJE, ZWOLNIONY, CHOROBOWE;
        public static final EnumSet<StatusZatrudnienia> allStatusyZatrudnienia = EnumSet.allOf(StatusZatrudnienia.class);
    }

    //ENUM TYPE of Rola:
    public enum Rola {
        KIEROWCA, OPIEKUN, MENADŻER;
        public static final EnumSet<Rola> allRola = EnumSet.allOf(Rola.class);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pesel;
    private String imie;
    private String nazwisko;
    @JsonProperty("data_urodzenia")
    @Column(columnDefinition = "date")
    private LocalDate dataUrodzenia;

    @OneToMany(mappedBy = "pracownik")
    @JsonBackReference
    private List<Wypozyczenie> wypozyczenia;

    @OneToOne
    private Opieka opieka;

    @Enumerated
    @Column(columnDefinition = "smallint")
    @JsonProperty("status_zatrudnienia")
    private StatusZatrudnienia statusZatrudnienia;

    @Enumerated
    @Column(columnDefinition = "smallint")
    private Rola rola;

    public Pracownik() {
    }


    public Pracownik(String pesel, String imie, String nazwisko, LocalDate dataUrodzenia, StatusZatrudnienia statusZatrudnienia, Rola rola) {
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.statusZatrudnienia = statusZatrudnienia;
        this.rola = rola;
    }

    public Pracownik(String pesel, String imie, String nazwisko, LocalDate dataUrodzenia, List<Wypozyczenie> wypozyczenia, Opieka opieka, StatusZatrudnienia statusZatrudnienia, Rola rola) {
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.wypozyczenia = wypozyczenia;
        this.opieka = opieka;
        this.statusZatrudnienia = statusZatrudnienia;
        this.rola = rola;
    }

    public Long getId() {
        return id;
    }

    public String getPesel() {
        return pesel;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public List<Wypozyczenie> getWypozyczenia() {
        return wypozyczenia;
    }

    public Opieka getOpieka() {
        return opieka;
    }

    public StatusZatrudnienia getStatusZatrudnienia() {
        return statusZatrudnienia;
    }

    public Rola getRola() {
        return rola;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public void setWypozyczenia(List<Wypozyczenie> wypozyczenia) {
        this.wypozyczenia = wypozyczenia;
    }

    public void setOpieka(Opieka opieka) {
        this.opieka = opieka;
    }

    public void setStatusZatrudnienia(StatusZatrudnienia statusZatrudnienia) {
        this.statusZatrudnienia = statusZatrudnienia;
    }

    public void setRola(Rola rola) {
        this.rola = rola;
    }
}
