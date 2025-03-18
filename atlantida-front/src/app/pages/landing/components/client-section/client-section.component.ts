import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-client-section',
  templateUrl: './client-section.component.html',
  styleUrl: './client-section.component.css'
})
export class ClientSectionComponent {
  constructor(
    private router: Router,
  ) {};

  navigateToStore() {
    this.router.navigate(['/store']);
    window.scrollTo(0, 0);
  };
}