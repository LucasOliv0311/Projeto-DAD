import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';
import { ProductViewModel } from '../../view-models';
import { count, firstValueFrom, Subscription } from 'rxjs';
import { ShopCartService } from '../../services/shop-cart/shop-cart.service';

@Component({
  selector: 'app-shop-cart',
  templateUrl: './shop-cart.component.html',
  styleUrl: './shop-cart.component.css'
})
export class ShopCartComponent {
  itemsId: number[] = [];
  products: ProductViewModel[] = [];
  private subscription!: Subscription;

  constructor(
    private router: Router,
    private authService: AuthService,
    private shopCartService: ShopCartService
  ) {};

  ngOnInit() {
    this.subscription = this.authService.shopCart$.subscribe(cart => {
      const requests = cart.map(id =>
        this.shopCartService.getProduct(id).toPromise()
      );
  
      Promise.all(requests).then(products => {
        this.products = products.filter((p): p is ProductViewModel => p !== undefined);
      });
    });
  };
  

  decreaseQuant(item: ProductViewModel) {
  };

  increaseQuant(item: ProductViewModel) {
  };

  removeItem(itemId: number) {
    this.authService.removeFromShopCart(itemId);
  };

  totalValue() {
  };

  totalItems() {
    let count = 0;
    this.products.forEach(i => {
      count ++;
    });
    return count;
  };

  navigateToStore() {
    this.router.navigate(['/store']);
    window.scrollTo(0, 0);
  };

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    };
  };
}