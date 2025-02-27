package com.example.scalasup.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Candidature")
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidature;

    @Column(nullable = false, length = 100)
    private String statut;

    @Column(nullable = false)
    private LocalDate dateSoumission;

    @ManyToOne
    @JoinColumn(name = "idEtudiant", nullable = false)
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "idUniversity", nullable = false)
    private University University;

    // Getters and Setters
    public Long getIdCandidature() {
        return idCandidature;
    }

    public void setIdCandidature(Long idCandidature) {
        this.idCandidature = idCandidature;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDate getDateSoumission() {
        return dateSoumission;
    }

    public void setDateSoumission(LocalDate dateSoumission) {
        this.dateSoumission = dateSoumission;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public University getUniversity() {
        return University;
    }

    public void setUniversity(University University) {
        this.University = University;
    }
}
