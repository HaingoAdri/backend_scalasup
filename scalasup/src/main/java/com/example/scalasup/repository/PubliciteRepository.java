package com.example.scalasup.repository;

import com.example.scalasup.entity.Publicite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubliciteRepository extends JpaRepository<Publicite, Long> {
} 