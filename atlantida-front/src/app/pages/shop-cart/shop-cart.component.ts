import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';
import { ProductViewModel } from '../../view-models';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-shop-cart',
  templateUrl: './shop-cart.component.html',
  styleUrl: './shop-cart.component.css'
})
export class ShopCartComponent {
  shopCart: ProductViewModel[] = [];
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

  decreaseQuant(item: ProductViewModel) {
  };

  increaseQuant(item: ProductViewModel) {
  };

  removeItem(item: ProductViewModel) {
  };

  totalValue() {
  };

  totalItems() {
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