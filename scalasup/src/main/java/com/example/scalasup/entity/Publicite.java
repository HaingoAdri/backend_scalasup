package com.example.scalasup.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "Publicite")
public class Publicite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPublicite;

    @Column(nullable = false, length = 255)
    private String titre;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, length = 255)
    private String campagne;

    @ManyToOne
    @JoinColumn(name = "idUniversite", nullable = false)
    private University university;

    // Getters and Setters
    public Long getIdPublicite() {
        return idPublicite;
    }

    public void setIdPublicite(Long idPublicite) {
        this.idPublicite = idPublicite;
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

    public String getCampagne() {
        return campagne;
    }

    public void setCampagne(String campagne) {
        this.campagne = campagne;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
