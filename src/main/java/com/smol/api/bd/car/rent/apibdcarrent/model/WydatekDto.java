package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WydatekDto {

    @JsonProperty("nazwa")
    private String nazwa;

    @JsonProperty("cena")
    private int cena;

    public WydatekDto(String nazwa, int cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getCena() {
        return cena;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}
