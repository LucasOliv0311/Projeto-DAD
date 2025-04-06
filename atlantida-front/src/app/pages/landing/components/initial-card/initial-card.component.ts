import { Component } from '@angular/core';
import { Router } from '@angular/router'; // Importe o Router

@Component({
  selector: 'app-initial-card',
  templateUrl: './initial-card.component.html',
  styleUrl: './initial-card.component.css'
})
export class InitialCardComponent {
  constructor(private router: Router) {};

  navigateToStore() {
    this.router.navigate(['/store']);
    window.scrollTo(0, 0);
  }
}