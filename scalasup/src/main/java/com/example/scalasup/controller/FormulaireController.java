package com.example.scalasup.controller;

import com.example.scalasup.entity.Formulaire;
import com.example.scalasup.repository.FormulaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formulaires")
public class FormulaireController {

    @Autowired
    private FormulaireRepository formulaireRepository;

    @GetMapping
    public List<Formulaire> getAllFormulaires() {
        return formulaireRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formulaire> getFormulaireById(@PathVariable Long id) {
        return formulaireRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Formulaire createFormulaire(@RequestBody Formulaire formulaire) {
        return formulaireRepository.save(formulaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formulaire> updateFormulaire(@PathVariable Long id, @RequestBody Formulaire formulaireDetails) {
        return formulaireRepository.findById(id)
                .map(formulaire -> {
                    formulaire.setTitre(formulaireDetails.getTitre());
                    formulaire.setDescription(formulaireDetails.getDescription());
                    formulaire.setUniversite(formulaireDetails.getUniversite());
                    return ResponseEntity.ok(formulaireRepository.save(formulaire));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFormulaire(@PathVariable Long id) {
        return formulaireRepository.findById(id)
                .map(formulaire -> {
                    formulaireRepository.delete(formulaire);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 