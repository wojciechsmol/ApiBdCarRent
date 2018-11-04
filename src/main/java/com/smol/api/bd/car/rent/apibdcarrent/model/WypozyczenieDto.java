package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import java.time.LocalDateTime;

public class WypozyczenieDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("planowana_data_rozpoczecia")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime planowanaDataRozpoczecia;

    @JsonProperty("planowana_data_zakonczenia")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd HH:mm")
    private LocalDateTime planowanaDataZakonczenia;

    @JsonProperty("faktyczna_data_rozpoczecia")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd HH:mm")
    private LocalDateTime faktycznaDataRozpoczecia;

    @JsonProperty("faktyczna_data_zakonczenia")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd HH:mm")
    private LocalDateTime faktycznaDataZakonczenia;

    @JsonProperty("przebieg_rozpoczecia")
    private int przebiegRozpoczecia;

    @JsonProperty("przebieg_zakonczenia")
    private int przebiegZakonczenia;

    @JsonProperty("id_pracownika")
    private Long idPracownika;

    @JsonProperty("id_pojazdu")
    private Long idPojazdu;

    @JsonProperty("status_wypozyczenia")
    private Wypozyczenie.statusyWypozyczen statusWypozyczenia;

    public WypozyczenieDto() {
    }

    public WypozyczenieDto(Long id, LocalDateTime planowanaDataRozpoczecia, LocalDateTime planowanaDataZakonczenia, LocalDateTime faktycznaDataRozpoczecia, LocalDateTime faktycznaDataZakonczenia, int przebiegRozpoczecia, int przebiegZakonczenia, Long idPracownika, Long idPojazdu, Wypozyczenie.statusyWypozyczen statusWypozyczenia) {
        this.id = id;
        this.planowanaDataRozpoczecia = planowanaDataRozpoczecia;
        this.planowanaDataZakonczenia = planowanaDataZakonczenia;
        this.faktycznaDataRozpoczecia = faktycznaDataRozpoczecia;
        this.faktycznaDataZakonczenia = faktycznaDataZakonczenia;
        this.przebiegRozpoczecia = przebiegRozpoczecia;
        this.przebiegZakonczenia = przebiegZakonczenia;
        this.idPracownika = idPracownika;
        this.idPojazdu = idPojazdu;
        this.statusWypozyczenia = statusWypozyczenia;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getPlanowanaDataRozpoczecia() {
        return planowanaDataRozpoczecia;
    }

    public LocalDateTime getPlanowanaDataZakonczenia() {
        return planowanaDataZakonczenia;
    }

    public LocalDateTime getFaktycznaDataRozpoczecia() {
        return faktycznaDataRozpoczecia;
    }

    public LocalDateTime getFaktycznaDataZakonczenia() {
        return faktycznaDataZakonczenia;
    }

    public int getPrzebiegRozpoczecia() {
        return przebiegRozpoczecia;
    }

    public int getPrzebiegZakonczenia() {
        return przebiegZakonczenia;
    }

    public Long getIdPracownika() {
        return idPracownika;
    }

    public Long getIdPojazdu() {
        return idPojazdu;
    }

    public Wypozyczenie.statusyWypozyczen getStatusWypozyczenia() {
        return statusWypozyczenia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlanowanaDataRozpoczecia(LocalDateTime planowanaDataRozpoczecia) {
        this.planowanaDataRozpoczecia = planowanaDataRozpoczecia;
    }

    public void setPlanowanaDataZakonczenia(LocalDateTime planowanaDataZakonczenia) {
        this.planowanaDataZakonczenia = planowanaDataZakonczenia;
    }

    public void setFaktycznaDataRozpoczecia(LocalDateTime faktycznaDataRozpoczecia) {
        this.faktycznaDataRozpoczecia = faktycznaDataRozpoczecia;
    }

    public void setFaktycznaDataZakonczenia(LocalDateTime faktycznaDataZakonczenia) {
        this.faktycznaDataZakonczenia = faktycznaDataZakonczenia;
    }

    public void setPrzebiegRozpoczecia(int przebiegRozpoczecia) {
        this.przebiegRozpoczecia = przebiegRozpoczecia;
    }

    public void setPrzebiegZakonczenia(int przebiegZakonczenia) {
        this.przebiegZakonczenia = przebiegZakonczenia;
    }

    public void setIdPracownika(Long idPracownika) {
        this.idPracownika = idPracownika;
    }

    public void setIdPojazdu(Long idPojazdu) {
        this.idPojazdu = idPojazdu;
    }

    public void setStatusWypozyczenia(Wypozyczenie.statusyWypozyczen statusWypozyczenia) {
        this.statusWypozyczenia = statusWypozyczenia;
    }
}
