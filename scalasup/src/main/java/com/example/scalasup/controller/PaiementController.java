package com.example.scalasup.controller;

import com.example.scalasup.entity.Paiement;
import com.example.scalasup.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementRepository paiementRepository;

    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable Long id) {
        return paiementRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Paiement createPaiement(@RequestBody Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paiement> updatePaiement(@PathVariable Long id, @RequestBody Paiement paiementDetails) {
        return paiementRepository.findById(id)
                .map(paiement -> {
                    paiement.setMontant(paiementDetails.getMontant());
                    paiement.setDate(paiementDetails.getDate());
                    paiement.setStatut(paiementDetails.getStatut());
                    paiement.setEtudiant(paiementDetails.getEtudiant());
                    return ResponseEntity.ok(paiementRepository.save(paiement));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaiement(@PathVariable Long id) {
        return paiementRepository.findById(id)
                .map(paiement -> {
                    paiementRepository.delete(paiement);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 