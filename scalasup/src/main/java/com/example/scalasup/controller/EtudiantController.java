package com.example.scalasup.controller;

import com.example.scalasup.entity.Etudiant;
import com.example.scalasup.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        return etudiantRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiantDetails) {
        return etudiantRepository.findById(id)
                .map(etudiant -> {
                    etudiant.setNom(etudiantDetails.getNom());
                    etudiant.setEmail(etudiantDetails.getEmail());
                    etudiant.setDateNaissance(etudiantDetails.getDateNaissance());
                    etudiant.setPassword(etudiantDetails.getPassword());
                    return ResponseEntity.ok(etudiantRepository.save(etudiant));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEtudiant(@PathVariable Long id) {
        return etudiantRepository.findById(id)
                .map(etudiant -> {
                    etudiantRepository.delete(etudiant);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Etudiant> getEtudiantByEmail(@PathVariable String email) {
        Etudiant etudiant = etudiantRepository.findByEmail(email);
        return etudiant != null ? ResponseEntity.ok(etudiant) : ResponseEntity.notFound().build();
    }
} 