package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WydatekKierowcyDto {

    @JsonProperty("id_kierowcy")
    private Long idKierowcy;

    @JsonProperty("wydatki")
    private int wydatki;

    public WydatekKierowcyDto(Long idKierowcy, int wydatki) {
        this.idKierowcy = idKierowcy;
        this.wydatki = wydatki;
    }

    public Long getIdKierowcy() {
        return idKierowcy;
    }

    public int getWydatki() {
        return wydatki;
    }

    public void setIdKierowcy(Long idKierowcy) {
        this.idKierowcy = idKierowcy;
    }

    public void setWydatki(int wydatki) {
        this.wydatki = wydatki;
    }
}
