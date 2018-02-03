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

    public PojazdDto(Long id, String opiekun, String nrRej, int przebieg, Pojazd.statusPojazdu status, MarkaDto marka, ModelDto model) {
        this.id = id;
        this.opiekun = opiekun;
        this.nrRej = nrRej;
        this.przebieg = przebieg;
        this.status = status;
        this.marka = marka;
        this.model = model;
    }
}
