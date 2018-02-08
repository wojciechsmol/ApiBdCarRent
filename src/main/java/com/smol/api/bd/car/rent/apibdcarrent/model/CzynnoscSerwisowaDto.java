package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CzynnoscSerwisowaDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nazwa")
    private String nazwa;

    @JsonProperty("data")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private LocalDate data;

    @JsonProperty("cena")
    private int cena;

    @JsonProperty("id_pojazdu")
    private Long idPojazdu;


    public CzynnoscSerwisowaDto() {
    }

    public CzynnoscSerwisowaDto(Long id, String nazwa, LocalDate data, int cena, Long idPojazdu) {
        this.id = id;
        this.nazwa = nazwa;
        this.data = data;
        this.cena = cena;
        this.idPojazdu = idPojazdu;
    }

    public Long getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public LocalDate getData() {
        return data;
    }

    public int getCena() {
        return cena;
    }

    public Long getIdPojazdu() {
        return idPojazdu;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setIdPojazdu(Long idPojazdu) {
        this.idPojazdu = idPojazdu;
    }

}
