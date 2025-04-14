import { Component, ViewChild } from '@angular/core';
import { AdminSpaceAddProductComponent } from './components/add-product/add-product.component';

@Component({
  selector: 'atlantida-admin-space-products-area',
  templateUrl: './products-area.component.html',
  styleUrl: './products-area.component.css'
})
export class AdminSpaceProductsAreaComponent {
  @ViewChild('modalComponent') modalComponent!: AdminSpaceAddProductComponent;
  
    openModal(): void {
      if (this.modalComponent) {
        this.modalComponent.openModal();
      } else {
        console.warn('Modal não inicializado ainda!');
      }
    }
}
