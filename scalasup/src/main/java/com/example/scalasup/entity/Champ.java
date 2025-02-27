package com.example.scalasup.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Champ")
public class Champ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChamp;

    @Column(nullable = false, length = 100)
    private String type;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private Boolean obligatoire;

    @ManyToOne
    @JoinColumn(name = "idFormulaire", nullable = false)
    private Formulaire formulaire;

    // Getters and Setters
    public Long getIdChamp() {
        return idChamp;
    }

    public void setIdChamp(Long idChamp) {
        this.idChamp = idChamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getObligatoire() {
        return obligatoire;
    }

    public void setObligatoire(Boolean obligatoire) {
        this.obligatoire = obligatoire;
    }

    public Formulaire getFormulaire() {
        return formulaire;
    }

    public void setFormulaire(Formulaire formulaire) {
        this.formulaire = formulaire;
    }
}
