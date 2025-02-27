package com.example.scalasup.controller;

import com.example.scalasup.entity.Reponse;
import com.example.scalasup.repository.ReponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reponses")
public class ReponseController {

    @Autowired
    private ReponseRepository reponseRepository;

    @GetMapping
    public List<Reponse> getAllReponses() {
        return reponseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reponse> getReponseById(@PathVariable Long id) {
        return reponseRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reponse createReponse(@RequestBody Reponse reponse) {
        return reponseRepository.save(reponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reponse> updateReponse(@PathVariable Long id, @RequestBody Reponse reponseDetails) {
        return reponseRepository.findById(id)
                .map(reponse -> {
                    reponse.setValeur(reponseDetails.getValeur());
                    reponse.setChamp(reponseDetails.getChamp());
                    return ResponseEntity.ok(reponseRepository.save(reponse));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReponse(@PathVariable Long id) {
        return reponseRepository.findById(id)
            .map(reponse -> {
                reponseRepository.delete(reponse);
                return ResponseEntity.ok().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
} 