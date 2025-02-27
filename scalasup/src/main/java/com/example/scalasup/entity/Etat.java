package com.example.scalasup.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Etat")
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtat;

    @Column(nullable = false, length = 255)
    private String nom;

    @Column(nullable = false)
    private String description;

    // Getters and Setters
    public Long getIdEtat() {
        return idEtat;
    }

    public void setIdEtat(Long idEtat) {
        this.idEtat = idEtat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
