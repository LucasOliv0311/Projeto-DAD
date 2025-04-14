import { Component, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AdminSpaceAddClientComponent } from './components/add-client/add-client.component';

@Component({
  selector: 'atlantida-admin-space-clients-area',
  templateUrl: './clients-area.component.html',
  styleUrl: './clients-area.component.css'
})
export class AdminSpaceClientsAreaComponent {

  @ViewChild('modalComponent') modalComponent!: AdminSpaceAddClientComponent;

  openModal(): void {
    if (this.modalComponent) {
      this.modalComponent.openModal();
    } else {
      console.warn('Modal não inicializado ainda!');
    }
  }
  
  constructor(private router: Router){}

}
