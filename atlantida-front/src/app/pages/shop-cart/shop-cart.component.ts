import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';
import { CartViewModel, ProductViewModel } from '../../view-models';
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
      const requests = cart.map(item => 
        this.shopCartService.getProduct(item.itemId).toPromise().then(product => {
          if (product) {
            product.quantidade = item.quantity;
          }
          return product;
        })
      );
  
      Promise.all(requests).then(products => {
        this.products = products.filter((p): p is ProductViewModel => p !== undefined);
      });
    });
  };
  
  decreaseQuant(item: ProductViewModel) {
    item.quantidade! -= 1;
    if (item.quantidade! === 0) {
      this.removeItem(item.id);
    };
  };

  increaseQuant(item: ProductViewModel) {
    item.quantidade! += 1;
  };

  removeItem(itemId: number) {
    this.authService.removeFromShopCart(itemId);
  };

  productValue(product: ProductViewModel) {
    return product.quantidade! * product.preco;
  };

  totalValue() {
    let total = 0;
    this.products.forEach(item => {
      total += item.preco * (item.quantidade ?? 0);
    });
    return total;
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