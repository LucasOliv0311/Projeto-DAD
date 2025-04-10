import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { ProductViewModel, UserViewModel } from '../../view-models';
import { ItemViewModel } from '../../view-models';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private userData: BehaviorSubject<UserViewModel | null>;
  private shopCart: BehaviorSubject<ProductViewModel[]>;

  user$: Observable<UserViewModel | null>;
  shopCart$: Observable<ProductViewModel[]>;

  constructor() {
    const storedUser = localStorage.getItem('userData');
    const storedShopCart = localStorage.getItem('shopCart');

    this.userData = new BehaviorSubject<UserViewModel | null>(storedUser ? JSON.parse(storedUser) : null);
    this.shopCart = new BehaviorSubject<ProductViewModel[]>(storedShopCart ? JSON.parse(storedShopCart) : []);

    this.user$ = this.userData.asObservable();
    this.shopCart$ = this.shopCart.asObservable();
  };

  login(user: UserViewModel) {
    this.userData.next(user);
    localStorage.setItem('userData', JSON.stringify(user));
    return true;
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

  addToShopCart(addedItem: ProductViewModel) {
    
  };

  removeFromShopCart(removedItem: ItemViewModel) {
    const currentCart = this.shopCart.value;
    const updatedCart = currentCart.filter(item => item.id !== removedItem.id);
    
    this.shopCart.next(updatedCart);
    localStorage.setItem('shopCart', JSON.stringify(updatedCart));
  };

  decreaseQuant(updatedItem: ItemViewModel) {
    
  }

  increaseQuant(updatedItem: ItemViewModel) {
    
  };

  clearShopCart() {
    this.shopCart.next([]);
    localStorage.removeItem('shopCart');
  };
}
