import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProductViewModel } from '../../../../view-models'
import { LandingService } from '../../../../services';

@Component({
  selector: 'app-best-offers',
  templateUrl: './best-offers.component.html',
  styleUrl: './best-offers.component.css'
})
export class BestOffersComponent {
  products: ProductViewModel[] = [];

  constructor(
    private landingService: LandingService,
    private router: Router
  ) {}

  ngOnInit() {
    this.landingService.getProducts().subscribe({
      next: (data) => {
        this.products = data;
        console.log(this.products);
      },
      error: (err) => console.error('Erro ao buscar produtos:', err),
    });
  }

  navigateToPurchase() {
    this.router.navigate(['store/purchase']);
    window.scrollTo(0, 0);
  };
  
  navigateToStore() {
    this.router.navigate(['/store']);
    window.scrollTo(0, 0);
  };
}
