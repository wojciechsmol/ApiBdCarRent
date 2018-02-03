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

    @JoinTable(name="marka_serwis", joinColumns=@JoinColumn(name="id_marki", referencedColumnName="ID"), inverseJoinColumns=@JoinColumn(name="id_serwisu", referencedColumnName="ID"))
    @ElementCollection(targetClass=Serwis.class)
    @JsonBackReference
    private List<Serwis> serwisy;

    public Marka() {
    }

    public Marka(String opis, List<Model> modele, List<Serwis> serwisy) {
        this.opis = opis;
        this.modele = modele;
        this.serwisy = serwisy;
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

    public List<Serwis> getSerwisy() {
        return serwisy;
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

    public void setSerwisy(List<Serwis> serwisy) {
        this.serwisy = serwisy;
    }
}
