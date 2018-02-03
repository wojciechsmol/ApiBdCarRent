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
    private Wypozyczenie wypozyczenie;

    public CzynnoscEksploatacyjna() {
    }

    public CzynnoscEksploatacyjna(rodzajCzynnoscEksploatacyjnej rodzajCzynnosciEksploatacyjnej, LocalDate data, int cena, Wypozyczenie wypozyczenie) {
        this.rodzajCzynnosciEksploatacyjnej = rodzajCzynnosciEksploatacyjnej;
        this.data = data;
        this.cena = cena;
        this.wypozyczenie = wypozyczenie;
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

    public Wypozyczenie getWypozyczenie() {
        return wypozyczenie;
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

    public void setWypozyczenie(Wypozyczenie wypozyczenie) {
        this.wypozyczenie = wypozyczenie;
    }
}
