package com.example.scalasup.controller;

import com.example.scalasup.entity.Messagerie;
import com.example.scalasup.repository.MessagerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessagerieController {

    @Autowired
    private MessagerieRepository messagerieRepository;

    @GetMapping
    public List<Messagerie> getAllMessages() {
        return messagerieRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Messagerie> getMessageById(@PathVariable Long id) {
        return messagerieRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Messagerie createMessage(@RequestBody Messagerie message) {
        return messagerieRepository.save(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Messagerie> updateMessage(@PathVariable Long id, @RequestBody Messagerie messageDetails) {
        return messagerieRepository.findById(id)
                .map(message -> {
                    message.setExpediteur(messageDetails.getExpediteur());
                    message.setDestinataire(messageDetails.getDestinataire());
                    message.setContenu(messageDetails.getContenu());
                    message.setDateEnvoi(messageDetails.getDateEnvoi());
                    message.setLu(messageDetails.getLu());
                    message.setEtudiantExpediteur(messageDetails.getEtudiantExpediteur());
                    message.setEtudiantDestinataire(messageDetails.getEtudiantDestinataire());
                    return ResponseEntity.ok(messagerieRepository.save(message));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable Long id) {
        return messagerieRepository.findById(id)
                .map(message -> {
                    messagerieRepository.delete(message);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 