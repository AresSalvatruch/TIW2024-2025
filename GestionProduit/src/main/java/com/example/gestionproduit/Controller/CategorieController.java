package com.example.gestionproduit.Controller;

import com.example.gestionproduit.Models.Categorie;
import com.example.gestionproduit.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  
@RequestMapping("/category")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    // Add a new category
    @PostMapping("/add")
    public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie) {
        Categorie newCategorie = categorieService.addCategorie(categorie);
        return ResponseEntity.ok(newCategorie);
    }

    // Get all categories
    @GetMapping("/all")
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

    // Get category by ID
    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Long id) {
        Optional<Categorie> categorie = categorieService.getCategorieById(id);
        if (categorie.isPresent()) {
            return ResponseEntity.ok(categorie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete category by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable Long id) {
        Optional<Categorie> categorie = categorieService.getCategorieById(id);
        if (categorie.isPresent()) {
            categorieService.deleteCategorie(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
