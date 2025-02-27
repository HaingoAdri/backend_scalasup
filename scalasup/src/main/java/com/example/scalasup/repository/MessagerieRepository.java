package com.example.scalasup.repository;

import com.example.scalasup.entity.Messagerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagerieRepository extends JpaRepository<Messagerie, Long> {
} 