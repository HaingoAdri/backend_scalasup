package com.example.scalasup.controller;

import com.example.scalasup.entity.Publicite;
import com.example.scalasup.repository.PubliciteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicites")
public class PubliciteController {

    @Autowired
    private PubliciteRepository publiciteRepository;

    @GetMapping
    public List<Publicite> getAllPublicites() {
        return publiciteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicite> getPubliciteById(@PathVariable Long id) {
        return publiciteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Publicite createPublicite(@RequestBody Publicite publicite) {
        return publiciteRepository.save(publicite);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publicite> updatePublicite(@PathVariable Long id, @RequestBody Publicite publiciteDetails) {
        return publiciteRepository.findById(id)
                .map(publicite -> {
                    publicite.setTitre(publiciteDetails.getTitre());
                    publicite.setDescription(publiciteDetails.getDescription());
                    publicite.setCampagne(publiciteDetails.getCampagne());
                    publicite.setUniversity(publiciteDetails.getUniversity());
                    return ResponseEntity.ok(publiciteRepository.save(publicite));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePublicite(@PathVariable Long id) {
        return publiciteRepository.findById(id)
                .map(publicite -> {
                    publiciteRepository.delete(publicite);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 