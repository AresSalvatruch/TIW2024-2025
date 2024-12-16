import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-afficher-produits',
  standalone: true,
  templateUrl: './afficher-produit.component.html',
  styleUrls: ['./afficher-produit.component.css'],
  imports: [CommonModule, FormsModule],
})
export class AfficherProduitsComponent implements OnInit {
  produits: any[] = []; // List of products
  categories: any[] = []; // List of categories
  categorieId: number | null = null; // Selected category ID

  constructor(private produitService: ProductService) {}

  ngOnInit(): void {
    this.getCategories();
    this.getProduits(); // Fetch all products initially
  }

  // Fetch all products or products by category
  getProduits(): void {
    console.log('Selected Category ID:', this.categorieId);

    if (this.categorieId) {
      this.produitService.getProduitsParCategorie(this.categorieId).subscribe({
        next: (data) => {
          console.log('Filtered Products:', data);
          this.produits = data;
        },
        error: (error) => {
          console.error('Error fetching filtered products:', error);
        },
      });
    } else {
      this.produitService.getAllProducts().subscribe({
        next: (data) => {
          console.log('All Products:', data);
          this.produits = data;
        },
        error: (error) => {
          console.error('Error fetching all products:', error);
        },
      });
    }
  }

  // Fetch all categories
  getCategories(): void {
    this.produitService.getAllCategories().subscribe({
      next: (data) => {
        console.log('Categories:', data);
        this.categories = data;
      },
      error: (error) => {
        console.error('Error fetching categories:', error);
      },
    });
  }
}
