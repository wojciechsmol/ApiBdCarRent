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

    @JsonProperty("data_rozpoczecia")
    @Column(columnDefinition = "date")
    private LocalDate dataRozpoczecia;

    @JsonProperty("data_zakonczenia")
    @Column(columnDefinition = "date")
    private LocalDate dataZakonczenia;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonManagedReference
    private Pracownik pracownik;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonManagedReference
    private Pojazd pojazd;

    public Opieka() {
    }

    public Opieka(LocalDate dataRozpoczecia, LocalDate dataZakonczenia, Pracownik pracownik, Pojazd pojazd) {
        this.dataRozpoczecia = dataRozpoczecia;
        this.dataZakonczenia = dataZakonczenia;
        this.pracownik = pracownik;
        this.pojazd = pojazd;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public LocalDate getDataZakonczenia() {
        return dataZakonczenia;
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

    public void setDataRozpoczecia(LocalDate dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public void setDataZakonczenia(LocalDate dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public void setPojazd(Pojazd pojazd) {
        this.pojazd = pojazd;
    }
}
