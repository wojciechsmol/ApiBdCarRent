package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Wypozyczenie {

    //ENUM Type of statusyWypozyczen
    public enum statusyWypozyczen {
        ZAREZERWOWANE, WYPOŻYCZONE, ZAKOŃCZONE;
        public static final EnumSet<statusyWypozyczen> allStatusyWypozyczen = EnumSet.allOf(statusyWypozyczen.class);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "datetime2")
    @JsonProperty("planowana_data_rozpoczecia")
    private LocalDateTime planowanaDataRozpoczecia;
    @Column(columnDefinition = "datetime2")
    @JsonProperty("planowana_data_zakonczenia")
    private LocalDateTime planowanaDataZakonczenia;
    @Column(columnDefinition = "datetime2")
    @JsonProperty("faktyczna_data_rozpoczecia")
    private LocalDateTime faktycznaDataRozpoczecia;
    @Column(columnDefinition = "datetime2")
    @JsonProperty("faktyczna_data_zakonczenia")
    private LocalDateTime faktycznaDataZakonczenia;

    @JsonProperty("przebieg_rozpoczecia")
    private int przebiegRozpoczecia;

    @JsonProperty("przebieg_zakonczenia")
    private int przebiegZakonczenia;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonManagedReference
    private Pracownik pracownik;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonManagedReference
    private Pojazd pojazd;



    @Enumerated
    @Column(columnDefinition = "smallint")
    @JsonProperty("status_wypozyczenia")
    private statusyWypozyczen statusWypozyczenia;

    @OneToMany(mappedBy = "wypozyczenie")
    @JsonBackReference
    private List<CzynnoscSerwisowa> czynnosciSerwisowe;

    @OneToMany(mappedBy = "wypozyczenie")
    @JsonBackReference
    private List<CzynnoscEksploatacyjna> czynnosciEksploatacyjne;


    public Wypozyczenie() {
    }

    public Wypozyczenie(LocalDateTime planowanaDataRozpoczecia, LocalDateTime planowanaDataZakonczenia, LocalDateTime faktycznaDataRozpoczecia, LocalDateTime faktycznaDataZakonczenia, int przebiegRozpoczecia, int przebiegZakonczenia, Pracownik pracownik, Pojazd pojazd, statusyWypozyczen statusWypozyczenia) {
        this.planowanaDataRozpoczecia = planowanaDataRozpoczecia;
        this.planowanaDataZakonczenia = planowanaDataZakonczenia;
        this.faktycznaDataRozpoczecia = faktycznaDataRozpoczecia;
        this.faktycznaDataZakonczenia = faktycznaDataZakonczenia;
        this.przebiegRozpoczecia = przebiegRozpoczecia;
        this.przebiegZakonczenia = przebiegZakonczenia;
        this.pracownik = pracownik;
        this.pojazd = pojazd;
        this.statusWypozyczenia = statusWypozyczenia;
    }

    public Wypozyczenie(LocalDateTime planowanaDataRozpoczecia, LocalDateTime planowanaDataZakonczenia, LocalDateTime faktycznaDataRozpoczecia, LocalDateTime faktycznaDataZakonczenia, int przebiegRozpoczecia, int przebiegZakonczenia, Pracownik pracownik, Pojazd pojazd, statusyWypozyczen statusWypozyczenia, List<CzynnoscSerwisowa> czynnosciSerwisowe, List<CzynnoscEksploatacyjna> czynnosciEksploatacyjne) {
        this.planowanaDataRozpoczecia = planowanaDataRozpoczecia;
        this.planowanaDataZakonczenia = planowanaDataZakonczenia;
        this.faktycznaDataRozpoczecia = faktycznaDataRozpoczecia;
        this.faktycznaDataZakonczenia = faktycznaDataZakonczenia;
        this.przebiegRozpoczecia = przebiegRozpoczecia;
        this.przebiegZakonczenia = przebiegZakonczenia;
        this.pracownik = pracownik;
        this.pojazd = pojazd;
        this.statusWypozyczenia = statusWypozyczenia;
        this.czynnosciSerwisowe = czynnosciSerwisowe;
        this.czynnosciEksploatacyjne = czynnosciEksploatacyjne;
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

    public Pracownik getPracownik() {
        return pracownik;
    }

    public Pojazd getPojazd() {
        return pojazd;
    }

    public statusyWypozyczen getStatusWypozyczenia() {
        return statusWypozyczenia;
    }

    public List<CzynnoscSerwisowa> getCzynnosciSerwisowe() {
        return czynnosciSerwisowe;
    }

    public List<CzynnoscEksploatacyjna> getCzynnosciEksploatacyjne() {
        return czynnosciEksploatacyjne;
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

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public void setPojazd(Pojazd pojazd) {
        this.pojazd = pojazd;
    }

    public void setStatusWypozyczenia(statusyWypozyczen statusWypozyczenia) {
        this.statusWypozyczenia = statusWypozyczenia;
    }

    public void setCzynnosciSerwisowe(List<CzynnoscSerwisowa> czynnosciSerwisowe) {
        this.czynnosciSerwisowe = czynnosciSerwisowe;
    }

    public void setCzynnosciEksploatacyjne(List<CzynnoscEksploatacyjna> czynnosciEksploatacyjne) {
        this.czynnosciEksploatacyjne = czynnosciEksploatacyjne;
    }
}
