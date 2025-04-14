import { Component, Input, SimpleChanges } from '@angular/core';
import { AuthService } from '../../../../services/auth/auth.service';
import { PurchaseService } from '../../../../services/purchase/purchase.service';
import { ProductViewModel, UserViewModel } from '../../../../view-models';

@Component({
  selector: 'atlantida-purchase-product-info',
  templateUrl: './product-info.component.html',
  styleUrl: './product-info.component.css'
})
export class PurchaseProductInfoComponent {
  userData: UserViewModel | null = null;
  @Input() id!: number;
  product!: ProductViewModel;
  quantity = 1;

  constructor (
    private authService: AuthService,
    private purchaseService: PurchaseService
  ) {};

  ngOnInit() {
    this.authService.user$.subscribe(data => {
      this.userData = data;
    });

  };

  ngOnChanges(changes: SimpleChanges) {
    if (changes['id'] && this.id) {
  
      this.purchaseService.getProduct(this.id).subscribe({
        next: (product) => {
          this.product = product;
        },
        error: (err) => {
          console.error("Erro ao buscar produto:", err);
        }
      });
    }
  }

  addToShopCart(itemId: number, quantity: number) {
    this.authService.addToShopCart(itemId, quantity);
  };

  decreaseQuant() {
    if (this.quantity > 1) {
      this.quantity -= 1;
    };
  };

  increaseQuant() {
    this.quantity += 1;
  };
}
