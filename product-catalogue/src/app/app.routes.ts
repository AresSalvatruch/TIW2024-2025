import { Routes } from '@angular/router';
import { AfficherProduitsComponent } from './afficher-produit/afficher-produit.component';
import { AjouterProduitComponent } from './ajouter-produit/ajouter-produit.component';

export const routes: Routes = [
  { path: '', redirectTo: 'produits', pathMatch: 'full' },
  { path: 'produits', component: AfficherProduitsComponent },
  { path: 'ajouter', component: AjouterProduitComponent },
];

