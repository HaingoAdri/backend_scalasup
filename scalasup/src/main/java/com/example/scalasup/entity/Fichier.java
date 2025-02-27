package com.example.scalasup.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Fichier")
public class Fichier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFichier;

    @Column(nullable = false, length = 255)
    private String nomFichier;

    @Column(nullable = false, length = 100)
    private String typeFichier;

    @Column(nullable = false)
    private Integer tailleFichier;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateTelechargement;

    @ManyToOne
    @JoinColumn(name = "idEtudiant", nullable = false)
    private Etudiant etudiant;

    // Getters and Setters
    public Long getIdFichier() {
        return idFichier;
    }

    public void setIdFichier(Long idFichier) {
        this.idFichier = idFichier;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public String getTypeFichier() {
        return typeFichier;
    }

    public void setTypeFichier(String typeFichier) {
        this.typeFichier = typeFichier;
    }

    public Integer getTailleFichier() {
        return tailleFichier;
    }

    public void setTailleFichier(Integer tailleFichier) {
        this.tailleFichier = tailleFichier;
    }

    public Date getDateTelechargement() {
        return dateTelechargement;
    }

    public void setDateTelechargement(Date dateTelechargement) {
        this.dateTelechargement = dateTelechargement;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
