package com.example.scalasup.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "Formulaire")
public class Formulaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")   
    private String description;

    @ManyToOne
    @JoinColumn(name = "idUniversite", nullable = false)
    private University universite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public University getUniversite() {
        return universite;
    }

    public void setUniversite(University universite) {
        this.universite = universite;
    }
}
