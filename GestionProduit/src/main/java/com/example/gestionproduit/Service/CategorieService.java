package com.example.gestionproduit.Service;

import com.example.gestionproduit.Models.Categorie;
import com.example.gestionproduit.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    // Add a new category
    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    // Get all categories
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    // Get category by ID
    public Optional<Categorie> getCategorieById(Long id) {
        return categorieRepository.findById(id);
    }

    // Delete category by ID
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}
