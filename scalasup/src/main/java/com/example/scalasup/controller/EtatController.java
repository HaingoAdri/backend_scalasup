package com.example.scalasup.controller;

import com.example.scalasup.entity.Etat;
import com.example.scalasup.repository.EtatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etats")
public class EtatController {

    @Autowired
    private EtatRepository etatRepository;

    @GetMapping
    public List<Etat> getAllEtats() {
        return etatRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etat> getEtatById(@PathVariable Long id) {
        return etatRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Etat createEtat(@RequestBody Etat etat) {
        return etatRepository.save(etat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etat> updateEtat(@PathVariable Long id, @RequestBody Etat etatDetails) {
        return etatRepository.findById(id)
                .map(etat -> {
                    etat.setNom(etatDetails.getNom());
                    etat.setDescription(etatDetails.getDescription());
                    return ResponseEntity.ok(etatRepository.save(etat));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEtat(@PathVariable Long id) {
        return etatRepository.findById(id)
                .map(etat -> {
                    etatRepository.delete(etat);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}