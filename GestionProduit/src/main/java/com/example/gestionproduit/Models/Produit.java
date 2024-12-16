package com.example.gestionproduit.Models;
import jakarta.persistence.*;
@Entity
@Table(name = "products")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "reference")
    private String reference;
    @Column(name = "description")
    private String description;
    @Column(name = "price_unit")
    private Double priceUnit;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Categorie category;
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Double priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Categorie getCategory() {
        return category;
    }

    public void setCategory(Categorie category) {
        this.category = category;
    }
}
