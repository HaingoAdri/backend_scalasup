package com.example.scalasup.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Reponse")
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReponse;

    @Column(nullable = false)
    private String valeur;

    @ManyToOne
    @JoinColumn(name = "idChamp", nullable = false)
    private Champ champ;

    // Getters and Setters
    public Long getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(Long idReponse) {
        this.idReponse = idReponse;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Champ getChamp() {
        return champ;
    }

    public void setChamp(Champ champ) {
        this.champ = champ;
    }
}
