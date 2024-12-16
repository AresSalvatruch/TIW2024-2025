import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficherProduitsComponent } from './afficher-produit.component';

describe('AfficherProduitComponent', () => {
  let component: AfficherProduitsComponent;
  let fixture: ComponentFixture<AfficherProduitsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AfficherProduitsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AfficherProduitsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
