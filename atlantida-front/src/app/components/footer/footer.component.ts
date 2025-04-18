import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {
  constructor(private router: Router) {};

  goToStore() {
    this.router.navigate(['store']);
    window.scrollTo(0, 0);
  };
  goToLanding() {
    this.router.navigate(['']);
    window.scrollTo(0, 0);
  }
  goToAdminSpace() {
    this.router.navigate(['/admin-space']);
    window.scrollTo(0, 0);
  };
}