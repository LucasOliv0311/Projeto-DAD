import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';
import { UserViewModel } from '../../view-models';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  userData: UserViewModel | null = null;

  constructor(
    private router: Router,
    private authService: AuthService
  ) {};

  ngOnInit() {
    this.authService.user$.subscribe(data => {
      this.userData = data;
    });
  };

  goToLanding() {
    this.router.navigate(['']);
    window.scrollTo(0, 0);
  };

  goToSignup() {
    this.router.navigate(['/register/signup']);
    window.scrollTo(0, 0);
  };

  goToLogin() {
    this.router.navigate(['/register/login']);
    window.scrollTo(0, 0);
  };

  goToShopCart() {
    this.router.navigate(['shop-cart']);
    window.scrollTo(0, 0);
  };

  logout() {
    this.authService.logout();
    this.goToLogin();
  };
}
