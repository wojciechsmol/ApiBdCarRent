package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class WypozyczenieDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("planowana_data_rozpoczecia")
    private LocalDateTime planowanaDataRozpoczecia;

    @JsonProperty("planowana_data_zakonczenia")
    private LocalDateTime planowanaDataZakonczenia;

    @JsonProperty("faktyczna_data_rozpoczecia")
    private LocalDateTime faktycznaDataRozpoczecia;

    @JsonProperty("faktyczna_data_zakonczenia")
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


}
