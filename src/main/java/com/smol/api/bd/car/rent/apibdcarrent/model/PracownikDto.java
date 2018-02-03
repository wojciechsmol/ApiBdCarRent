package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.time.LocalDate;

public class PracownikDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("pesel")
    private String pesel;
    @JsonProperty("imie")
    private String imie;
    @JsonProperty("nazwisko")
    private String nazwisko;
    @JsonProperty("data_urodzenia")
    private LocalDate dataUrodzenia;

    @JsonProperty("status_zatrudnienia")
    private Pracownik.StatusZatrudnienia statusZatrudnienia;

    @JsonProperty("rola")
    private Pracownik.Rola rola;

    public PracownikDto() {
    }

    public PracownikDto(Long id, String pesel, String imie, String nazwisko, LocalDate dataUrodzenia, Pracownik.StatusZatrudnienia statusZatrudnienia, Pracownik.Rola rola) {
        this.id = id;
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

    public Pracownik.StatusZatrudnienia getStatusZatrudnienia() {
        return statusZatrudnienia;
    }

    public Pracownik.Rola getRola() {
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

    public void setStatusZatrudnienia(Pracownik.StatusZatrudnienia statusZatrudnienia) {
        this.statusZatrudnienia = statusZatrudnienia;
    }

    public void setRola(Pracownik.Rola rola) {
        this.rola = rola;
    }
}
