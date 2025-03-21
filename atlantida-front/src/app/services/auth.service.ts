import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { UserViewModel } from '../view-models';
import { ItemViewModel } from '../view-models/item.vm';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private usersLoginList: BehaviorSubject<UserViewModel[]>;
  private userData: BehaviorSubject<UserViewModel | null>;
  private shopCart: BehaviorSubject<ItemViewModel[]>;

  usersLoginList$: Observable<UserViewModel[]>;
  user$: Observable<UserViewModel | null>;
  shopCart$: Observable<ItemViewModel[]>;

  constructor() {
    const storedUsersLoginList = localStorage.getItem('usersLoginList');
    const storedUser = localStorage.getItem('userData');
    const storedShopCart = localStorage.getItem('shopCart');

    this.usersLoginList = new BehaviorSubject<UserViewModel[]>(storedUsersLoginList ? JSON.parse(storedUsersLoginList) : []);
    this.userData = new BehaviorSubject<UserViewModel | null>(storedUser ? JSON.parse(storedUser) : null);
    this.shopCart = new BehaviorSubject<ItemViewModel[]>(storedShopCart ? JSON.parse(storedShopCart) : []);

    this.usersLoginList$ = this.usersLoginList.asObservable();
    this.user$ = this.userData.asObservable();
    this.shopCart$ = this.shopCart.asObservable();
  };

  signup(newUser: UserViewModel) {
    const currentUsersList = this.usersLoginList.value;
  
    const userExists = currentUsersList.some(user => user.nome === newUser.nome);
    if (userExists) {
      return false;
    };
  
    const updatedUsersList = [...currentUsersList, newUser];
    
    this.usersLoginList.next(updatedUsersList);
    localStorage.setItem('usersLoginList', JSON.stringify(updatedUsersList));
  
    return true;
  };

  login(loginUser: UserViewModel) {
    const user = this.usersLoginList.value.find(user => 
      user.email === loginUser.email && user.password === loginUser.password
    );
  
    if (user) {
      this.userData.next(user);
      localStorage.setItem('userData', JSON.stringify(user));
      return true;
    };
  
    return false;
  };

  deleteUsers() {
    this.usersLoginList.next([]);
    localStorage.setItem('usersLoginList', JSON.stringify([]));
  };

  getUserData() {
    return this.userData.value ?? null;
  };

  getUsersData() {
    return this.usersLoginList.value;
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
        const newQuantity = (item.quantity ?? 0) + 1;
        return { ...item, quantity: newQuantity };
      }
      return item;
    });
  
    const itemExists = this.shopCart.value.some(item => item.id === addedItem.id);
    const updatedCart = itemExists ? currentCart : [...currentCart, { ...addedItem, quantity: 1 }];
  
    this.shopCart.next(updatedCart);
    localStorage.setItem('shopCart', JSON.stringify(updatedCart));
  };

  removeFromShopCart(removedItem: ItemViewModel) {
    const currentCart = this.shopCart.value;
    const updatedCart = currentCart.filter(item => item.id !== removedItem.id);
    
    this.shopCart.next(updatedCart);
    localStorage.setItem('shopCart', JSON.stringify(updatedCart));
  };

  decreaseQuant(updatedItem: ItemViewModel) {
    const currentCart = this.shopCart.value
      .map(item => {
        if (item.id === updatedItem.id && (item.quantity ?? 0) > 1) {
          return { ...item, quantity: item.quantity! - 1 };
        }
        return item;
      })
      .filter(item => item.quantity && item.quantity > 0);
  
    this.shopCart.next(currentCart);
    localStorage.setItem('shopCart', JSON.stringify(currentCart));
  }

  increaseQuant(updatedItem: ItemViewModel) {
    const currentCart = this.shopCart.value.map(item => {
      if (item.id === updatedItem.id) {
        const newQuantity = (item.quantity ?? 0) + 1;
        return { ...item, quantity: newQuantity };
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
