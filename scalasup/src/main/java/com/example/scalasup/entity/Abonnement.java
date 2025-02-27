package com.example.scalasup.entity;
import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Abonnement")
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbonnement;

    @Column(nullable = false, length = 100)
    private String type;

    @Column(nullable = false)
    private Date dateDebut;

    @Column(nullable = false)
    private Date dateExpiration;

    @ManyToOne
    @JoinColumn(name = "idUniversite", nullable = false)
    private University university;

    // Getters and Setters
    public Long getIdAbonnement() {
        return idAbonnement;
    }

    public void setIdAbonnement(Long idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
