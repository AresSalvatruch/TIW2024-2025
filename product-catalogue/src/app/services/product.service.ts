import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private baseUrl = 'http://localhost:8080/products'; // Base URL for products
  private categoryUrl = 'http://localhost:8080/category'; // Base URL for categories

  constructor(private http: HttpClient) {}

  // Fetch all products
  getAllProducts(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all`);
  }

  // Fetch products by category
  // Fetch products by category
  getProduitsParCategorie(categoryId: number): Observable<any> {
    console.log(`Fetching products for category ID: ${categoryId}`);
    return this.http.get(`${this.baseUrl}/category/${categoryId}`);
  }

  // Fetch all categories
  getAllCategories(): Observable<any> {
    return this.http.get(`${this.categoryUrl}/all`);
  }
}
