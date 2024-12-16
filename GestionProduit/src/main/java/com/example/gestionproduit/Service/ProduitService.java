package com.example.gestionproduit.Service;
import com.example.gestionproduit.Models.Categorie;
import com.example.gestionproduit.Models.Produit;
import com.example.gestionproduit.Repository.ProduitRepository;
import com.example.gestionproduit.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    // Add a new product
    public Produit addProduit(Produit produit, Long categoryId) {
        // Find category by ID
        Optional<Categorie> categorie = categorieRepository.findById(categoryId);
        if (categorie.isPresent()) {
            produit.setCategory(categorie.get());
            return produitRepository.save(produit);
        }
        return null;  // Or throw exception if category is not found
    }

    // Get all products
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    // Get product by ID
    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    // Delete product by ID
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    // Get products by category
    public List<Produit> getProduitsByCategory(Long categoryId) {
        return produitRepository.findByCategoryId(categoryId);
    }
}

