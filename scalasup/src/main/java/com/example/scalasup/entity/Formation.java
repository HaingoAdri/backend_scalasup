package com.example.scalasup.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "Formation")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormation;

    @Column(nullable = false, length = 255)
    private String nom;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "idUniversite", nullable = false)
    private University university;

    // Getters and Setters
    public Long getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Long idFormation) {
        this.idFormation = idFormation;
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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
