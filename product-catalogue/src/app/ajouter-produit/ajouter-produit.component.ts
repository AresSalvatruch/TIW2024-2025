import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ProductService } from '../services/product.service'; // Corrected the service import
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ajouter-produit',
  standalone: true,
  templateUrl: './ajouter-produit.component.html',
  styleUrls: ['./ajouter-produit.component.css'],
  imports: [FormsModule, CommonModule],
})
export class AjouterProduitComponent implements OnInit {
  produit = {
    reference: '',
    description: '',
    prixUnitaire: 0,
    categorieId: null,
  };

  categories: any[] = []; // Array to hold dynamic categories

  constructor(
    private productService: ProductService // Fixed service name and type
  ) {}

  ngOnInit(): void {
    this.getCategories();
    // Initialize the produit object with default values
    this.produit = {
      reference: '',
      description: '',
      prixUnitaire: 1,
      categorieId: null, // This will be updated if categories are loaded
    };
  }

  getCategories(): void {
    this.productService.getAllCategories().subscribe(
      (data) => {
        console.log('Categories:', data);
        this.categories = data;
        if (this.categories.length > 0) {
          this.produit.categorieId = this.categories[0].id; // Set the default category
        }
      },
      (error) => {
        console.error('Error fetching categories:', error);
      }
    );
  }

 
  ajouterProduit(): void {
    // Check if category is selected
    if (this.produit.categorieId === null) {
      alert('Veuillez sélectionner une catégorie avant d\'ajouter un produit.');
      return;
    }

    // Call the product service to add the product
    this.productService.ajouterProduit(this.produit, this.produit.categorieId).subscribe(
      (response) => {
        console.log('Produit ajouté avec succès:', response);
        alert('Produit ajouté avec succès!');
        this.resetForm(); // Reset the form after successful addition
      },
      (error) => {
        console.error('Erreur lors de l\'ajout du produit:', error);
        alert('Erreur lors de l\'ajout du produit. Vérifiez les champs.');
      }
    );
  }

  // Reset the form fields
  private resetForm(): void {
    this.produit = {
      reference: '',
      description: '',
      prixUnitaire: 0,
      categorieId: null,
    };
  }
}
