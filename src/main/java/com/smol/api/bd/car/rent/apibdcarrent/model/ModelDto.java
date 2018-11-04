package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

public class ModelDto {


    @JsonProperty("id_modelu")
    private Long id;
    @JsonProperty("nazwa")
    private String nazwa;
    @JsonProperty("ilosc_miejsc")
    private int iloscMiejsc;
    @JsonProperty("rok_prod")
    private int rokProdukcji;

    @JsonProperty("nadwozie")
    private Model.typNadwozia typNadwozia;

    public ModelDto() {
    }

    public ModelDto(Long id, String nazwa, int iloscMiejsc, int rokProdukcji, Model.typNadwozia typNadwozia) {
        this.id = id;
        this.nazwa = nazwa;
        this.iloscMiejsc = iloscMiejsc;
        this.rokProdukcji = rokProdukcji;
        this.typNadwozia = typNadwozia;
    }

    public Long getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getIloscMiejsc() {
        return iloscMiejsc;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public Model.typNadwozia getTypNadwozia() {
        return typNadwozia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setIloscMiejsc(int iloscMiejsc) {
        this.iloscMiejsc = iloscMiejsc;
    }

    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public void setTypNadwozia(Model.typNadwozia typNadwozia) {
        this.typNadwozia = typNadwozia;
    }
}
