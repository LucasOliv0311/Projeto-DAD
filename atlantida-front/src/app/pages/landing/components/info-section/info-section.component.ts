import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-info-section',
  templateUrl: './info-section.component.html',
  styleUrl: './info-section.component.css'
})
export class InfoSectionComponent {
  constructor(
    private router: Router,
  ) {};

  navigateToStore() {
    this.router.navigate(['/store']);
    window.scrollTo(0, 0);
  };
}
