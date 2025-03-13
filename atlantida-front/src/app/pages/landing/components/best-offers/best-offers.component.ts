import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../../../services/auth.service';
import { ItemViewModel } from '../../../../view-models/item.vm';

@Component({
  selector: 'app-best-offers',
  templateUrl: './best-offers.component.html',
  styleUrl: './best-offers.component.css'
})
export class BestOffersComponent {
  items: ItemViewModel[] = [
    {
      id: 0,
      name: "Tilápia Fresca",
      price: 64.99,
      quantity: 1,
      image: "/assets/images/tilapia.png"
    },
    {
      id: 1,
      name: "Camarão",
      price: 49.99,
      quantity: 1,
      image: "/assets/images/camarao.png"
    },
    {
      id: 2,
      name: "Filé de Salmão",
      price: 54.99,
      quantity: 1,
      image: "/assets/images/salmao.png"
    },
    {
      id: 3,
      name: "Sardinha",
      price: 29.99,
      quantity: 1,
      image: "/assets/images/sardinha.jpg"
    }
  ];

  constructor(
    private router: Router,
    private authService: AuthService,
  ) {};

  addToShopCart(item: ItemViewModel) {
    this.authService.addToShopCart(item);
  }
  
  navigateToStore() {
    this.router.navigate(['/store']);
    window.scrollTo(0, 0);
  };
}
