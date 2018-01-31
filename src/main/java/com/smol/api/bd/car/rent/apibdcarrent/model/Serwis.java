package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Serwis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String adres;
    private String nazwa;

    @ManyToMany(mappedBy = "serwisy")
    private List<Marka> marki;

    @OneToMany(mappedBy = "serwis")
    @JsonBackReference
    private List<CzynnoscSerwisowa> czynnosciSerwisowe;

    public Serwis() {
    }

    public Serwis(String adres, String nazwa, List<Marka> marki, List<CzynnoscSerwisowa> czynnosciSerwisowe) {
        this.adres = adres;
        this.nazwa = nazwa;
        this.marki = marki;
        this.czynnosciSerwisowe = czynnosciSerwisowe;
    }

    public Long getId() {
        return id;
    }

    public String getAdres() {
        return adres;
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Marka> getMarki() {
        return marki;
    }

    public List<CzynnoscSerwisowa> getCzynnosciSerwisowe() {
        return czynnosciSerwisowe;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setMarki(List<Marka> marki) {
        this.marki = marki;
    }

    public void setCzynnosciSerwisowe(List<CzynnoscSerwisowa> czynnosciSerwisowe) {
        this.czynnosciSerwisowe = czynnosciSerwisowe;
    }
}
