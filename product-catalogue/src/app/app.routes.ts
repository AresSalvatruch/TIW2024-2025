import { Routes } from '@angular/router';
import { AfficherProduitsComponent } from './afficher-produit/afficher-produit.component'; // Correct import

export const routes: Routes = [
  { path: '', redirectTo: 'produits', pathMatch: 'full' },
  { path: 'produits', component: AfficherProduitsComponent }, // Correct class name here
];
