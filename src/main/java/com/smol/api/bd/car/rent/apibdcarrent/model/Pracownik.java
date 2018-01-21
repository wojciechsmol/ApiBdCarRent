package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.EnumSet;


@Entity
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

    public Long getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getPesel() {
        return pesel;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public StatusZatrudnienia getStatusZatrudnienia() {
        return statusZatrudnienia;
    }

    public Rola getRola() {
        return rola;
    }

    public void setPesel(String pesel) {
        if (pesel != null)
            this.pesel = pesel;
    }

    public void setNazwisko(String nazwisko) {

        if (nazwisko != null)
            this.nazwisko = nazwisko;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {

        if (dataUrodzenia != null)
            this.dataUrodzenia = dataUrodzenia;
    }

    public void setImie(String imie) {

        if (imie != null)
            this.imie = imie;
    }

    public void setStatusZatrudnienia(StatusZatrudnienia statusZatrudnienia) {
        if (statusZatrudnienia != null)
            this.statusZatrudnienia = statusZatrudnienia;
    }

    public void setRola(Rola rola) {

        if (rola != null)
            this.rola = rola;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id=" + id +
                ", pesel='" + pesel + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", statusZatrudnienia=" + statusZatrudnienia +
                ", rola=" + rola +
                '}';
    }
}
