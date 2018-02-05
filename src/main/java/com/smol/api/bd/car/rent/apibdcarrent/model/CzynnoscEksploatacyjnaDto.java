package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CzynnoscEksploatacyjnaDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nazwa")
    private CzynnoscEksploatacyjna.rodzajCzynnoscEksploatacyjnej mRodzajCzynnoscEksploatacyjnej;

    @JsonProperty("data")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd.MM.yyyy")
    private LocalDate data;

    @JsonProperty("cena")
    private int cena;

    @JsonProperty("id_pojazdu")
    private Long idPojazdu;

    public CzynnoscEksploatacyjnaDto() {
    }

    public CzynnoscEksploatacyjnaDto(Long id, CzynnoscEksploatacyjna.rodzajCzynnoscEksploatacyjnej rodzajCzynnoscEksploatacyjnej, LocalDate data, int cena, Long idPojazdu) {
        this.id = id;
        mRodzajCzynnoscEksploatacyjnej = rodzajCzynnoscEksploatacyjnej;
        this.data = data;
        this.cena = cena;
        this.idPojazdu = idPojazdu;
    }

    public Long getId() {
        return id;
    }

    public CzynnoscEksploatacyjna.rodzajCzynnoscEksploatacyjnej getRodzajCzynnoscEksploatacyjnej() {
        return mRodzajCzynnoscEksploatacyjnej;
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

    public void setRodzajCzynnoscEksploatacyjnej(CzynnoscEksploatacyjna.rodzajCzynnoscEksploatacyjnej rodzajCzynnoscEksploatacyjnej) {
        mRodzajCzynnoscEksploatacyjnej = rodzajCzynnoscEksploatacyjnej;
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
