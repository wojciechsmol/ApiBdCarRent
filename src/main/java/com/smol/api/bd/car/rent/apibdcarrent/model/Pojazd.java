package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pojazd {

    //ENUM TYPE of statusPojazdu
    public enum statusPojazdu {
        SPRAWNY, W_NAPRAWIE, ZŁOMOWANY;
        public static final EnumSet<statusPojazdu> allStatusyPojazdu = EnumSet.allOf(statusPojazdu.class);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Opieka opieka;

    @JsonProperty("nr_rej")
    private String nrRej;

    private int przebieg;

    @Enumerated
    @Column(columnDefinition = "smallint")
    private statusPojazdu status;

    @OneToMany(mappedBy = "pojazd")
    @JsonBackReference
    private List<Wypozyczenie> wypozyczenia;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Model model;

    @OneToMany(mappedBy = "pojazd")
    @JsonBackReference
    private List<EwidencjaKosztow> ewidencjeKosztow;

    @OneToMany(mappedBy = "pojazd")
    @JsonBackReference
    private List<CzynnoscSerwisowa> czynnosciSerwisowe;

    @OneToMany(mappedBy = "pojazd")
    @JsonBackReference
    private List<CzynnoscEksploatacyjna> czynnosciEksploatacyjne;


    public Pojazd() {
    }

    public Pojazd(Opieka opieka, String nrRej, int przebieg, statusPojazdu status, List<Wypozyczenie> wypozyczenia, Model model, List<EwidencjaKosztow> ewidencjeKosztow, List<CzynnoscSerwisowa> czynnosciSerwisowe, List<CzynnoscEksploatacyjna> czynnosciEksploatacyjne) {
        this.opieka = opieka;
        this.nrRej = nrRej;
        this.przebieg = przebieg;
        this.status = status;
        this.wypozyczenia = wypozyczenia;
        this.model = model;
        this.ewidencjeKosztow = ewidencjeKosztow;
        this.czynnosciSerwisowe = czynnosciSerwisowe;
        this.czynnosciEksploatacyjne = czynnosciEksploatacyjne;
    }

    public Pojazd(String nrRej, int przebieg, statusPojazdu status, Model model) {
        this.nrRej = nrRej;
        this.przebieg = przebieg;
        this.status = status;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public Opieka getOpieka() {
        return opieka;
    }

    public String getNrRej() {
        return nrRej;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public statusPojazdu getStatus() {
        return status;
    }

    public List<Wypozyczenie> getWypozyczenia() {
        return wypozyczenia;
    }

    public Model getModel() {
        return model;
    }

    public List<EwidencjaKosztow> getEwidencjeKosztow() {
        return ewidencjeKosztow;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOpieka(Opieka opieka) {
        this.opieka = opieka;
    }

    public void setNrRej(String nrRej) {
        this.nrRej = nrRej;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public void setStatus(statusPojazdu status) {
        this.status = status;
    }

    public void setWypozyczenia(List<Wypozyczenie> wypozyczenia) {
        this.wypozyczenia = wypozyczenia;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setEwidencjeKosztow(List<EwidencjaKosztow> ewidencjeKosztow) {
        this.ewidencjeKosztow = ewidencjeKosztow;
    }

    public List<CzynnoscSerwisowa> getCzynnosciSerwisowe() {
        return czynnosciSerwisowe;
    }

    public List<CzynnoscEksploatacyjna> getCzynnosciEksploatacyjne() {
        return czynnosciEksploatacyjne;
    }

    public void setCzynnosciSerwisowe(List<CzynnoscSerwisowa> czynnosciSerwisowe) {
        this.czynnosciSerwisowe = czynnosciSerwisowe;
    }

    public void setCzynnosciEksploatacyjne(List<CzynnoscEksploatacyjna> czynnosciEksploatacyjne) {
        this.czynnosciEksploatacyjne = czynnosciEksploatacyjne;
    }

    public boolean isTaken(LocalDateTime fromTime, LocalDateTime toTime) {

        if (opieka == null)
            return true;
        //Check all wypozyczenia of the car
        for (Wypozyczenie wypozyczenie : wypozyczenia) {

            if (wypozyczenie.getStatusWypozyczenia() != Wypozyczenie.statusyWypozyczen.ZAKOŃCZONE) {
                if (toTime.isBefore(wypozyczenie.getPlanowanaDataZakonczenia()) &&
                        fromTime.isAfter(wypozyczenie.getPlanowanaDataRozpoczecia()))
                    return true;
            }
        }
        return false;
    }

    public boolean isAvailable() {
        return status == statusPojazdu.SPRAWNY;
    }

    public boolean repairing() {return status == statusPojazdu.W_NAPRAWIE;}

}
