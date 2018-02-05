package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarkaDto {

    @JsonProperty("nazwa")
    private String opis;

    public MarkaDto() {
    }

    public MarkaDto(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
