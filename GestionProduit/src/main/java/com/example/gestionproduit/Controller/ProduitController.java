package com.example.gestionproduit.Controller;

import com.example.gestionproduit.Models.Produit;
import com.example.gestionproduit.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // Add a new product
    @PostMapping("/add/{categoryId}")
    public ResponseEntity<Produit> addProduit(@RequestBody Produit produit, @PathVariable Long categoryId) {
        Produit newProduit = produitService.addProduit(produit, categoryId);
        if (newProduit != null) {
            return ResponseEntity.ok(newProduit);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Get all products
    @GetMapping("/all")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }
    // Get products by category
        @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Produit>> getProduitsByCategory(@PathVariable Long categoryId) {
        List<Produit> produits = produitService.getProduitsByCategory(categoryId);
        if (!produits.isEmpty()) {
            return ResponseEntity.ok(produits);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        Optional<Produit> produit = produitService.getProduitById(id);
        if (produit.isPresent()) {
            return ResponseEntity.ok(produit.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete product by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        Optional<Produit> produit = produitService.getProduitById(id);
        if (produit.isPresent()) {
            produitService.deleteProduit(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
