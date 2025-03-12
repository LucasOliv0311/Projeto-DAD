import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { loginViewModel, UserViewModel } from '../view-models';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private userData: BehaviorSubject<UserViewModel | null>;
  user$: Observable<UserViewModel | null>;

  constructor() {
    const storedUser = localStorage.getItem('userData');
    this.userData = new BehaviorSubject<UserViewModel | null>(storedUser ? JSON.parse(storedUser) : null);
    this.user$ = this.userData.asObservable();
  };

  sendUserData(user: UserViewModel) {
    this.userData.next(user);
    localStorage.setItem('userData', JSON.stringify(user));
  };

  getUserData() {
    return this.userData;
  };

  logout() {
    this.userData.next(null);
    localStorage.removeItem('userData');
  }
}
