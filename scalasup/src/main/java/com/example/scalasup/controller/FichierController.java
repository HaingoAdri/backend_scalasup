package com.example.scalasup.controller;

import com.example.scalasup.entity.Fichier;
import com.example.scalasup.repository.FichierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fichiers")
public class FichierController {

    @Autowired
    private FichierRepository fichierRepository;

    @GetMapping
    public List<Fichier> getAllFichiers() {
        return fichierRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fichier> getFichierById(@PathVariable Long id) {
        return fichierRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Fichier createFichier(@RequestBody Fichier fichier) {
        return fichierRepository.save(fichier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fichier> updateFichier(@PathVariable Long id, @RequestBody Fichier fichierDetails) {
        return fichierRepository.findById(id)
                .map(fichier -> {
                    fichier.setNomFichier(fichierDetails.getNomFichier());
                    fichier.setTypeFichier(fichierDetails.getTypeFichier());
                    fichier.setTailleFichier(fichierDetails.getTailleFichier());
                    fichier.setDateTelechargement(fichierDetails.getDateTelechargement());
                    fichier.setEtudiant(fichierDetails.getEtudiant());
                    return ResponseEntity.ok(fichierRepository.save(fichier));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFichier(@PathVariable Long id) {
        return fichierRepository.findById(id)
                .map(fichier -> {
                    fichierRepository.delete(fichier);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 