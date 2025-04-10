import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ItemViewModel, ProductViewModel } from '../../../../view-models';
import { AuthService } from '../../../../services/auth/auth.service';
import { LandingService } from '../../../../services';

@Component({
  selector: 'atlantida-purchase-more-offers',
  templateUrl: './more-offers.component.html',
  styleUrl: './more-offers.component.css'
})
export class PurchaseMoreOffersComponent {
  products: ProductViewModel[] = [];

  constructor(
    private router: Router,
    private authService: AuthService,
    private landingService: LandingService
  ) {};

  ngOnInit() {
    this.landingService.getProducts().subscribe({
      next: (data) => {
        this.products = data;
      },
      error: (err) => console.error('Erro ao buscar produtos:', err),
    });
  }

  navigateToStore() {
    this.router.navigate(['/store']);
    window.scrollTo(0, 0);
  };

  addToShopCart(item: ProductViewModel) {
    this.authService.addToShopCart(item);
  };
}
