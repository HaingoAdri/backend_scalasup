package com.example.scalasup.entity;
import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    @Column(nullable = false, length = 255)
    private String nom;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(nullable = false)
    private Date dateNaissance;

    @Column(nullable = false, length = 255)
    private String password;

    // Getters and Setters
    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
