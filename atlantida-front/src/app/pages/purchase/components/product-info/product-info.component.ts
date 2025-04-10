import { Component } from '@angular/core';
import { ItemViewModel } from '../../../../view-models';
import { AuthService } from '../../../../services/auth/auth.service';
import { Router } from '@angular/router';
import { UserViewModel } from '../../../../view-models';

@Component({
  selector: 'atlantida-purchase-product-info',
  templateUrl: './product-info.component.html',
  styleUrl: './product-info.component.css'
})
export class PurchaseProductInfoComponent {
  userData: UserViewModel | null = null;
  item: ItemViewModel = {
    id: 2,
    name: "Filé de Salmão",
    price: 54.99,
    image: "/assets/images/salmao.png",
    quantity: 1,
  };

  constructor (
    private authService: AuthService,
    private router: Router
  ) {};

  ngOnInit() {
    this.authService.user$.subscribe(data => {
      this.userData = data;
    });
  }

  addToShopCart() {
    
  };

  // decreaseQuant() {
  //   if (this.item.quantity! > 1) {
  //     this.item.quantity! -= 1;
  //   };
  // };

  // increaseQuant() {
  //   this.item.quantity! += 1;
  // };
}
