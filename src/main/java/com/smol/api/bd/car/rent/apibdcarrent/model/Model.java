package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.EnumSet;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Model {

    //ENUM TYPE of typNadwozia
    public enum typNadwozia {
        HATCHBACK, SEDAN, VAN;
        public static final EnumSet<typNadwozia> allTypyNadwozia = EnumSet.allOf(typNadwozia.class);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nazwa;
    @JsonProperty("ilosc_miejsc")
    private int iloscMiejsc;
    @JsonProperty("rok_prod")
    private int rokProdukcji;

    @Enumerated
    @Column(columnDefinition = "smallint")
    @JsonProperty("typ_nadwozia")
    private typNadwozia typNadwozia;

    @OneToMany(mappedBy = "model")
    @JsonBackReference
    private List<Pojazd> pojazdy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Marka marka;

    public Model() {
    }

    public Model(String nazwa, int iloscMiejsc, int rokProdukcji, Model.typNadwozia typNadwozia, List<Pojazd> pojazdy, Marka marka) {
        this.nazwa = nazwa;
        this.iloscMiejsc = iloscMiejsc;
        this.rokProdukcji = rokProdukcji;
        this.typNadwozia = typNadwozia;
        this.pojazdy = pojazdy;
        this.marka = marka;
    }

    public Model(String nazwa, int iloscMiejsc, int rokProdukcji, Model.typNadwozia typNadwozia, Marka marka) {
        this.nazwa = nazwa;
        this.iloscMiejsc = iloscMiejsc;
        this.rokProdukcji = rokProdukcji;
        this.typNadwozia = typNadwozia;
        this.marka = marka;
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

    public List<Pojazd> getPojazdy() {
        return pojazdy;
    }

    public Marka getMarka() {
        return marka;
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

    public void setPojazdy(List<Pojazd> pojazdy) {
        this.pojazdy = pojazdy;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
    }
}
