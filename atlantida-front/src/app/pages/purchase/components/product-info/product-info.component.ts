import { Component, Input } from '@angular/core';
import { ItemViewModel, ProductViewModel } from '../../../../view-models';
import { AuthService } from '../../../../services/auth/auth.service';
import { Router } from '@angular/router';
import { UserViewModel } from '../../../../view-models';
import { PurchaseService } from '../../../../services/purchase/purchase.service';

@Component({
  selector: 'atlantida-purchase-product-info',
  templateUrl: './product-info.component.html',
  styleUrl: './product-info.component.css'
})
export class PurchaseProductInfoComponent {
  userData: UserViewModel | null = null;
  @Input() id!: number;
  product!: ProductViewModel;

  constructor (
    private authService: AuthService,
    private purchaseService: PurchaseService
  ) {};

  ngOnInit() {
    this.authService.user$.subscribe(data => {
      this.userData = data;
    });

    console.log("id: ", this.id);

    
  };

  addToShopCart(itemId: number) {
    this.authService.addToShopCart(itemId);
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
