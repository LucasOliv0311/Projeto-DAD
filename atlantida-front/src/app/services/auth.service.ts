import { Injectable } from '@angular/core';
import { BehaviorSubject, filter, Observable } from 'rxjs';
import { loginViewModel, UserViewModel } from '../view-models';
import { ItemViewModel } from '../view-models/item.vm';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private userData: BehaviorSubject<UserViewModel | null>;
  private shopCart: BehaviorSubject<ItemViewModel[]>;

  user$: Observable<UserViewModel | null>;
  shopCart$: Observable<ItemViewModel[]>

  constructor() {
    const storedUser = localStorage.getItem('userData');
    const storedShopCart = localStorage.getItem('shopCart');

    this.userData = new BehaviorSubject<UserViewModel | null>(storedUser ? JSON.parse(storedUser) : null);
    this.shopCart = new BehaviorSubject<ItemViewModel[]>(storedShopCart ? JSON.parse(storedShopCart) ?? [] : []);

    this.user$ = this.userData.asObservable();
    this.shopCart$ = this.shopCart.asObservable();
  };

  sendUserData(user: UserViewModel) {
    this.userData.next(user);
    localStorage.setItem('userData', JSON.stringify(user));
  };

  getUserData() {
    return this.userData.value ?? null;
  };

  logout() {
    this.userData.next(null);
    localStorage.removeItem('userData');
  };

  getShopCart() {
    return this.shopCart.value ?? [];
  };

  addToShopCart(addedItem: ItemViewModel) {
    const currentCart = this.shopCart.value.map(item => {
      if (item.id === addedItem.id) {
        return { ...item, quantity: item.quantity + 1 };
      }
      return item;
    });
  
    const itemExists = this.shopCart.value.some(item => item.id === addedItem.id);
    const updatedCart = itemExists ? currentCart : [...currentCart, { ...addedItem, quantity: 1 }];
  
    this.shopCart.next(updatedCart);
    localStorage.setItem('shopCart', JSON.stringify(updatedCart));
  }

  removeFromShopCart(removedItem: ItemViewModel) {
    const currentCart = this.shopCart.value;
    const updatedCart = currentCart.filter(item => item.id !== removedItem.id);
    
    this.shopCart.next(updatedCart);
    localStorage.setItem('shopCart', JSON.stringify(updatedCart));
  };

  decreaseQuant(updatedItem: ItemViewModel) {
    let currentCart = this.shopCart.value.map(item => {
      if (item.id === updatedItem.id) {
        if (item.quantity > 1) {
          return { ...item, quantity: item.quantity - 1 };
        } else {
          return null;
        }
      }
      return item;
    }).filter(item => item !== null) as ItemViewModel[];
  
    this.shopCart.next(currentCart);
    localStorage.setItem('shopCart', JSON.stringify(currentCart));
  };

  increaseQuant(updatedItem: ItemViewModel) {
    const currentCart = this.shopCart.value.map(item => {
      if (item.id === updatedItem.id) {
        return { ...item, quantity: item.quantity + 1 };
      };
      return item;
    });

    this.shopCart.next(currentCart);
    localStorage.setItem('shopCart', JSON.stringify(currentCart));
  };

  clearShopCart() {
    this.shopCart.next([]);
    localStorage.removeItem('shopCart');
  };
}
