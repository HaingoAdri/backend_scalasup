package com.example.scalasup.controller;

import com.example.scalasup.entity.Abonnement;
import com.example.scalasup.repository.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abonnements")
public class AbonnementController {

    @Autowired
    private AbonnementRepository abonnementRepository;

    @GetMapping
    public List<Abonnement> getAllAbonnements() {
        return abonnementRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abonnement> getAbonnementById(@PathVariable Long id) {
        return abonnementRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Abonnement createAbonnement(@RequestBody Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abonnement> updateAbonnement(@PathVariable Long id, @RequestBody Abonnement abonnementDetails) {
        return abonnementRepository.findById(id)
                .map(abonnement -> {
                    abonnement.setType(abonnementDetails.getType());
                    abonnement.setDateDebut(abonnementDetails.getDateDebut());
                    abonnement.setDateExpiration(abonnementDetails.getDateExpiration());
                    abonnement.setUniversity(abonnementDetails.getUniversity());
                    return ResponseEntity.ok(abonnementRepository.save(abonnement));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAbonnement(@PathVariable Long id) {
        return abonnementRepository.findById(id)
                .map(abonnement -> {
                    abonnementRepository.delete(abonnement);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}