package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.EnumSet;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CzynnoscEksploatacyjna {

    //ENUM TYPE of rodzajCzynnosciEksploatacyjnej
    public enum rodzajCzynnoscEksploatacyjnej{
        TANKOWANIE, DOLANIE_PŁYNU_DO_SPRYSKIWACZY, DOLANIE_OLEJU_SILNIKOWEGO;
        public static final EnumSet<rodzajCzynnoscEksploatacyjnej> allCzynnosciEksploatacyjne = EnumSet.allOf(rodzajCzynnoscEksploatacyjnej.class);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated
    @Column(columnDefinition = "smallint")
    @JsonProperty("nazwa")
    private rodzajCzynnoscEksploatacyjnej rodzajCzynnosciEksploatacyjnej;

    @Column(columnDefinition = "date")
    private LocalDate data;

    private int cena;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonManagedReference
    private Pojazd pojazd;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonManagedReference
    private Pracownik pracownik;

    public CzynnoscEksploatacyjna() {
    }

    public CzynnoscEksploatacyjna(rodzajCzynnoscEksploatacyjnej rodzajCzynnosciEksploatacyjnej, LocalDate data, int cena, Pojazd pojazd) {
        this.rodzajCzynnosciEksploatacyjnej = rodzajCzynnosciEksploatacyjnej;
        this.data = data;
        this.cena = cena;
        this.pojazd = pojazd;
    }

    public CzynnoscEksploatacyjna(rodzajCzynnoscEksploatacyjnej rodzajCzynnosciEksploatacyjnej, LocalDate data, int cena, Pojazd pojazd, Pracownik pracownik) {
        this.rodzajCzynnosciEksploatacyjnej = rodzajCzynnosciEksploatacyjnej;
        this.data = data;
        this.cena = cena;
        this.pojazd = pojazd;
        this.pracownik = pracownik;
    }


    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public Long getId() {
        return id;
    }

    public rodzajCzynnoscEksploatacyjnej getRodzajCzynnosciEksploatacyjnej() {
        return rodzajCzynnosciEksploatacyjnej;
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

    public void setRodzajCzynnosciEksploatacyjnej(rodzajCzynnoscEksploatacyjnej rodzajCzynnosciEksploatacyjnej) {
        this.rodzajCzynnosciEksploatacyjnej = rodzajCzynnosciEksploatacyjnej;
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
