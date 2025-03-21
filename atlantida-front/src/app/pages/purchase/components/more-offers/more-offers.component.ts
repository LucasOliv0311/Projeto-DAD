import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ItemViewModel } from '../../../../view-models/item.vm';
import { AuthService } from '../../../../services/auth.service';

@Component({
  selector: 'atlantida-purchase-more-offers',
  templateUrl: './more-offers.component.html',
  styleUrl: './more-offers.component.css'
})
export class PurchaseMoreOffersComponent {
  items: ItemViewModel[] = [
    {
      id: 0,
      name: "Tilápia Fresca",
      price: 64.99,
      image: "/assets/images/tilapia.png"
    },
    {
      id: 0,
      name: "Camarão",
      price: 49.99,
      image: "/assets/images/camarao.png"
    },
    {
      id: 0,
      name: "Filé de Salmão",
      price: 54.99,
      image: "/assets/images/salmao.png"
    },
    {
      id: 0,
      name: "Sardinha",
      price: 29.99,
      image: "/assets/images/sardinha.jpg"
    }
  ];

  constructor(
    private router: Router,
    private authService: AuthService
  ) {};

  navigateToStore() {
    this.router.navigate(['/store']);
    window.scrollTo(0, 0);
  };

  addToShopCart(item: ItemViewModel) {
    this.authService.addToShopCart(item);
  };
}
