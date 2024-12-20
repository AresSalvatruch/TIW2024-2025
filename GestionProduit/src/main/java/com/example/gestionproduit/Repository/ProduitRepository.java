package com.example.gestionproduit.Repository;


import com.example.gestionproduit.Models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByCategoryId(Long categoryId);

}
