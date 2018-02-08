package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Opieka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Pracownik pracownik;

    @OneToOne
    private Pojazd pojazd;

    public Opieka() {
    }

    public Opieka(Pracownik pracownik, Pojazd pojazd) {
        this.pracownik = pracownik;
        this.pojazd = pojazd;
    }

    public Long getId() {
        return id;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public Pojazd getPojazd() {
        return pojazd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public void setPojazd(Pojazd pojazd) {
        this.pojazd = pojazd;
    }
}
