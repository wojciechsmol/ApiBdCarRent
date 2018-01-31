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
    public enum rodzajCzynnosciSerwisowej{
        WYMIANA_ROZRZADU, NAPRAWY_LAKIERNICZE, WYMIANA_SILNIKA;
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
    private float cena;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonManagedReference
    private Wypozyczenie wypozyczenie;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonManagedReference
    private Serwis serwis;

    public CzynnoscSerwisowa() {
    }

    public CzynnoscSerwisowa(rodzajCzynnosciSerwisowej rodzajCzynnosciSerwisowej, LocalDate data, float cena, Wypozyczenie wypozyczenie, Serwis serwis) {
        RodzajCzynnosciSerwisowej = rodzajCzynnosciSerwisowej;
        this.data = data;
        this.cena = cena;
        this.wypozyczenie = wypozyczenie;
        this.serwis = serwis;
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

    public float getCena() {
        return cena;
    }

    public Wypozyczenie getWypozyczenie() {
        return wypozyczenie;
    }

    public Serwis getSerwis() {
        return serwis;
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

    public void setCena(float cena) {
        this.cena = cena;
    }

    public void setWypozyczenie(Wypozyczenie wypozyczenie) {
        this.wypozyczenie = wypozyczenie;
    }

    public void setSerwis(Serwis serwis) {
        this.serwis = serwis;
    }
}
