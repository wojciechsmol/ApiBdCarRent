package com.smol.api.bd.car.rent.apibdcarrent.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Marka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("nazwa")
    private String opis;

    @OneToMany(mappedBy = "marka")
    @JsonBackReference
    private List<Model> modele;


    public Marka() {
    }

    public Marka(String opis, List<Model> modele) {
        this.opis = opis;
        this.modele = modele;
    }

    public Marka(String opis) {
        this.opis = opis;
    }

    public Long getId() {
        return id;
    }

    public String getOpis() {
        return opis;
    }

    public List<Model> getModele() {
        return modele;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setModele(List<Model> modele) {
        this.modele = modele;
    }
}
