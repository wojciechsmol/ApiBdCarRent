package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WydatekRocznyDto {

    @JsonProperty("id_pojazdu")
    private Long idPojazdu;

    @JsonProperty("rok")
    private int rok;

    @JsonProperty("wydatek")
    private List<WydatekDto> wydatkiDto;

    public WydatekRocznyDto(Long idPojazdu, int rok, List<WydatekDto> wydatkiDto) {
        this.idPojazdu = idPojazdu;
        this.rok = rok;
        this.wydatkiDto = wydatkiDto;
    }

    public Long getIdPojazdu() {
        return idPojazdu;
    }

    public int getRok() {
        return rok;
    }

    public List<WydatekDto> getWydatkiDto() {
        return wydatkiDto;
    }

    public void setIdPojazdu(Long idPojazdu) {
        this.idPojazdu = idPojazdu;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public void setWydatkiDto(List<WydatekDto> wydatkiDto) {
        this.wydatkiDto = wydatkiDto;
    }
}
