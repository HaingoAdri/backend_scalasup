package com.example.scalasup.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre", length = 255)
    private String titre;

    @Column(name = "contenu")
    private String contenu;

    @Column(name = "datePublication")
    private Date datePublication;

    @ManyToOne
    @JoinColumn(name = "idUniversite", nullable = false)
    private University universite;

    // Getters and Setters
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

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public University getUniversite() {
        return universite;
    }

    public void setUniversite(University universite) {
        this.universite = universite;
    }
}
