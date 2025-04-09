import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';
import { ItemViewModel } from '../../view-models';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-shop-cart',
  templateUrl: './shop-cart.component.html',
  styleUrl: './shop-cart.component.css'
})
export class ShopCartComponent {
  shopCart: ItemViewModel[] = [];
  private subscription!: Subscription;

  constructor(
    private router: Router,
    private authService: AuthService,
  ) {};

  ngOnInit() {
    this.subscription = this.authService.shopCart$.subscribe(cart => {
      this.shopCart = cart;
    });
  };

  decreaseQuant(item: ItemViewModel) {
    this.authService.decreaseQuant(item);
  };

  increaseQuant(item: ItemViewModel) {
    this.authService.increaseQuant(item);
  };

  removeItem(item: ItemViewModel) {
    this.authService.removeFromShopCart(item);
  };

  totalValue() {
    return this.shopCart.reduce((total, item) => total + item.price * item.quantity!, 0);
  };

  totalItems() {
    return this.shopCart.reduce((total, item) => total + item.quantity!, 0);
  };

  navigateToStore() {
    this.router.navigate(['/store']);
    window.scrollTo(0, 0);
  };

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  };
}