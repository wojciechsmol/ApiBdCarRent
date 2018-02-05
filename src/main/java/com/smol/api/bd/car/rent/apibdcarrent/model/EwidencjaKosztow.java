package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EwidencjaKosztow {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("data_wydatku")
    @Column(columnDefinition = "date")
    private LocalDate data;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonManagedReference
    private Pojazd pojazd;

    @JsonProperty("id_kierowcy")
    private Long idKierowcy;

    @JsonProperty("nazwa_czynnosci")
    private String nazwaCzynnosci;

    public EwidencjaKosztow() {
    }

    public EwidencjaKosztow(LocalDate data, Pojazd pojazd, Long idKierowcy, String nazwaCzynnosci) {
        this.data = data;
        this.pojazd = pojazd;
        this.idKierowcy = idKierowcy;
        this.nazwaCzynnosci = nazwaCzynnosci;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Pojazd getPojazd() {
        return pojazd;
    }

    public Long getIdKierowcy() {
        return idKierowcy;
    }

    public String getNazwaCzynnosci() {
        return nazwaCzynnosci;
    }

    public void setIdKierowcy(Long idKierowcy) {
        this.idKierowcy = idKierowcy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setPojazd(Pojazd pojazd) {
        this.pojazd = pojazd;
    }

    public void setNazwaCzynnosci(String nazwaCzynnosci) {
        this.nazwaCzynnosci = nazwaCzynnosci;
    }
}
