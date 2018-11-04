package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.EnumSet;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CzynnoscSerwisowa {


    //ENUM TYPE of rodzajCzynnosciSerwisowej
    public enum rodzajCzynnosciSerwisowej {
        WYMIANA_ROZRZĄDU, NAPRAWY_LAKIERNICZE, WYMIANA_SILNIKA;
        public static final EnumSet<rodzajCzynnosciSerwisowej> allCzynnosciSerwisowe = EnumSet.allOf(rodzajCzynnosciSerwisowej.class);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    @Column(columnDefinition = "smallint")
    @JsonProperty("nazwa")
    private rodzajCzynnosciSerwisowej RodzajCzynnosciSerwisowej;

    @JsonProperty("data")
    @Column(columnDefinition = "date")
    private LocalDate data;
    private int cena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Pojazd pojazd;

    public CzynnoscSerwisowa() {
    }

    public CzynnoscSerwisowa(rodzajCzynnosciSerwisowej rodzajCzynnosciSerwisowej, LocalDate data, int cena, Pojazd pojazd) {
        RodzajCzynnosciSerwisowej = rodzajCzynnosciSerwisowej;
        this.data = data;
        this.cena = cena;
        this.pojazd = pojazd;
    }

    public Long getId() {
        return id;
    }

    public rodzajCzynnosciSerwisowej getRodzajCzynnosciSerwisowej() {
        return RodzajCzynnosciSerwisowej;
    }

    public LocalDate getData() {
        return data;
    }

    public int getCena() {
        return cena;
    }

    public Pojazd getPojazd() {
        return pojazd;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setRodzajCzynnosciSerwisowej(rodzajCzynnosciSerwisowej rodzajCzynnosciSerwisowej) {
        RodzajCzynnosciSerwisowej = rodzajCzynnosciSerwisowej;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setPojazd(Pojazd pojazd) {
        this.pojazd = pojazd;
    }
}
