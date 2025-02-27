package com.example.scalasup.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticle;

    @Column(nullable = false, length = 255)
    private String titre;

    @Column(nullable = false)
    private String contenu;

    @Column(nullable = false)
    private Date datePublication;

    @ManyToOne
    @JoinColumn(name = "idUniversite", nullable = false)
    private University universite;

    // Getters and Setters
    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
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
