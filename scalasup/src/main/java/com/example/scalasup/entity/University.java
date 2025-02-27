package com.example.scalasup.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "University")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    @Column(nullable = false, length = 255)
    private String nom;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @ManyToOne
    @JoinColumn(name = "idAdmin")
    private Admin admin;

    // Getters and Setters
    public Long getIdUniversite() {
        return idUniversite;
    }

    public void setIdUniversite(Long idUniversite) {
        this.idUniversite = idUniversite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
