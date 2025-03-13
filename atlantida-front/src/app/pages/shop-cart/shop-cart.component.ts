import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-shop-cart',
  templateUrl: './shop-cart.component.html',
  styleUrl: './shop-cart.component.css'
})
export class ShopCartComponent {
  items = [
    {
      id: 0,
      name: 'tilápia',
      price: 74.99,
      image: '/assets/images/tilapia.png',
      quantity: 1,
    },
    {
      id: 1,
      name: 'salmão',
      price: 74.99,
      image: '/assets/images/salmao.png',
      quantity: 1,
    },
    {
      id: 2,
      name: 'salmão',
      price: 74.99,
      image: '/assets/images/salmao.png',
      quantity: 1,
    },
    {
      id: 3,
      name: 'salmão',
      price: 74.99,
      image: '/assets/images/salmao.png',
      quantity: 1,
    },
    {
      id: 4,
      name: 'salmão',
      price: 74.99,
      image: '/assets/images/salmao.png',
      quantity: 1,
    },
    {
      id: 5,
      name: 'salmão',
      price: 74.99,
      image: '/assets/images/salmao.png',
      quantity: 1,
    },
  ];

  constructor(private router: Router) {};

  decreaseQuant(index: number) {
    this.items[index].quantity -= 1;

    if (this.items[index].quantity === 0) {
      this.removeItem(index);
    };
  };

  increaseQuant(index: number) {
    this.items[index].quantity += 1;
  };

  removeItem(index: number) {
    this.items.splice(index, 1);
  };

  totalValue() {
    return this.items.reduce((total, item) => total + item.price * item.quantity, 0);
  };

  totalItems() {
    return this.items.reduce((total, item) => total + item.quantity, 0);
  };

  navigateToStore() {
    this.router.navigate(['/store']);
    window.scrollTo(0, 0);
  };
}