package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Date;

public class WydatekWMiesiacuDto {

    @JsonProperty("rok")
    private int rok;

    @JsonProperty("miesiac")
    private String miesiac;

    @JsonProperty("cena")
    private int cena;

    @JsonIgnore
    private LocalDate data;

    public WydatekWMiesiacuDto(int rok, String miesiac, int cena, LocalDate data) {
        this.rok = rok;
        this.miesiac = miesiac;
        this.cena = cena;
        this.data = data;
    }

    public int getRok() {
        return rok;
    }

    public String getMiesiac() {
        return miesiac;
    }

    public int getCena() {
        return cena;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public void setMiesiac(String miesiac) {
        this.miesiac = miesiac;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
