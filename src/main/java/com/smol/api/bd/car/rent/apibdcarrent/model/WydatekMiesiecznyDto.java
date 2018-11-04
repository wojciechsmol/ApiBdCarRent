package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WydatekMiesiecznyDto {


    @JsonProperty("id_pojazdu")
    private Long idPojazdu;

    @JsonProperty("miesiac")
    private String miesiac;

    @JsonProperty("wydatek")
    private List<WydatekDto> wydatkiDto;

    public WydatekMiesiecznyDto(Long idPojazdu, String miesiac, List<WydatekDto> wydatkiDto) {
        this.idPojazdu = idPojazdu;
        this.miesiac = miesiac;
        this.wydatkiDto = wydatkiDto;
    }

    public Long getIdPojazdu() {
        return idPojazdu;
    }

    public String getMiesiac() {
        return miesiac;
    }

    public List<WydatekDto> getWydatkiDto() {
        return wydatkiDto;
    }

    public void setIdPojazdu(Long idPojazdu) {
        this.idPojazdu = idPojazdu;
    }

    public void setMiesiac(String miesiac) {
        this.miesiac = miesiac;
    }

    public void setWydatkiDto(List<WydatekDto> wydatkiDto) {
        this.wydatkiDto = wydatkiDto;
    }
}
