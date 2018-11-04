package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

public class PojazdDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("opiekun")
    private String opiekun;

    @JsonProperty("id_opiekuna")
    private Long idOpiekuna;

    @JsonProperty("nr_rej")
    private String nrRej;

    @JsonProperty("przebieg")
    private int przebieg;

    @JsonProperty("status")
    private Pojazd.statusPojazdu status;

    @JsonProperty("marka")
    private MarkaDto marka;

    @JsonProperty("model")
    private ModelDto model;

    public PojazdDto() {
    }

    public PojazdDto(Long id, String opiekun, Long idOpiekuna, String nrRej, int przebieg, Pojazd.statusPojazdu status, MarkaDto marka, ModelDto model) {
        this.id = id;
        this.opiekun = opiekun;
        this.idOpiekuna = idOpiekuna;
        this.nrRej = nrRej;
        this.przebieg = przebieg;
        this.status = status;
        this.marka = marka;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public String getOpiekun() {
        return opiekun;
    }

    public String getNrRej() {
        return nrRej;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public Pojazd.statusPojazdu getStatus() {
        return status;
    }

    public MarkaDto getMarka() {
        return marka;
    }

    public ModelDto getModel() {
        return model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOpiekun(String opiekun) {
        this.opiekun = opiekun;
    }

    public void setNrRej(String nrRej) {
        this.nrRej = nrRej;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public void setStatus(Pojazd.statusPojazdu status) {
        this.status = status;
    }

    public void setMarka(MarkaDto marka) {
        this.marka = marka;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }

    public Long getIdOpiekuna() {
        return idOpiekuna;
    }

    public void setIdOpiekuna(Long idOpiekuna) {
        this.idOpiekuna = idOpiekuna;
    }
}
