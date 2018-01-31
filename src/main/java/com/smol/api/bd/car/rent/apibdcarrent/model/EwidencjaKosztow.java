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

    @Enumerated
    @Column(columnDefinition = "smallint")
    @JsonProperty("nazwa_wydatku")
    private CzynnoscEksploatacyjna.rodzajCzynnoscEksploatacyjnej rodzajCzynnosciEksploatacyjnej;

    public EwidencjaKosztow() {
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

    public CzynnoscEksploatacyjna.rodzajCzynnoscEksploatacyjnej getRodzajCzynnosciEksploatacyjnej() {
        return rodzajCzynnosciEksploatacyjnej;
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

    public void setRodzajCzynnosciEksploatacyjnej(CzynnoscEksploatacyjna.rodzajCzynnoscEksploatacyjnej rodzajCzynnosciEksploatacyjnej) {
        this.rodzajCzynnosciEksploatacyjnej = rodzajCzynnosciEksploatacyjnej;
    }
}
