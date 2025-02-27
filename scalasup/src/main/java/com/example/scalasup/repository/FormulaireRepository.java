package com.example.scalasup.repository;

import com.example.scalasup.entity.Formulaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulaireRepository extends JpaRepository<Formulaire, Long> {
} 