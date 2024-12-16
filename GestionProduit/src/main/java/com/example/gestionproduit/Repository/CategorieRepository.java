package com.example.gestionproduit.Repository;

import com.example.gestionproduit.Models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
