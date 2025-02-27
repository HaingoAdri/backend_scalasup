package com.example.scalasup.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Messagerie")
public class Messagerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;

    @Column(nullable = false, length = 255)
    private String expediteur;

    @Column(nullable = false, length = 255) 
    private String destinataire;

    @Column(nullable = false)
    private String contenu;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateEnvoi;

    @Column(nullable = false)
    private Boolean lu = false;

    @ManyToOne
    @JoinColumn(name = "idEtudiantExp", nullable = false)
    private Etudiant etudiantExpediteur;

    @ManyToOne
    @JoinColumn(name = "idEtudiantDest", nullable = false)
    private Etudiant etudiantDestinataire;

    // Getters and Setters
    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public Boolean getLu() {
        return lu;
    }

    public void setLu(Boolean lu) {
        this.lu = lu;
    }

    public Etudiant getEtudiantExpediteur() {
        return etudiantExpediteur;
    }

    public void setEtudiantExpediteur(Etudiant etudiantExpediteur) {
        this.etudiantExpediteur = etudiantExpediteur;
    }

    public Etudiant getEtudiantDestinataire() {
        return etudiantDestinataire;
    }

    public void setEtudiantDestinataire(Etudiant etudiantDestinataire) {
        this.etudiantDestinataire = etudiantDestinataire;
    }
}
