package com.example.scalasup.controller;

import com.example.scalasup.entity.Facture;
import com.example.scalasup.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factures")
public class FactureController {

    @Autowired
    private FactureRepository factureRepository;

    @GetMapping
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facture> getFactureById(@PathVariable Long id) {
        return factureRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Facture createFacture(@RequestBody Facture facture) {
        return factureRepository.save(facture);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facture> updateFacture(@PathVariable Long id, @RequestBody Facture factureDetails) {
        return factureRepository.findById(id)
                .map(facture -> {
                    facture.setNumero(factureDetails.getNumero());
                    facture.setMontant(factureDetails.getMontant());
                    facture.setDateEmission(factureDetails.getDateEmission());
                    facture.setDateEcheance(factureDetails.getDateEcheance());
                    facture.setEtudiant(factureDetails.getEtudiant());
                    return ResponseEntity.ok(factureRepository.save(facture));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFacture(@PathVariable Long id) {
        return factureRepository.findById(id)
                .map(facture -> {
                    factureRepository.delete(facture);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 