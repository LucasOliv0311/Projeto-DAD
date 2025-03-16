import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'store-products-product-box',
  templateUrl: './product-box.component.html',
  styleUrls: ['./product-box.component.css']
})
export class StoreProductBoxComponent {

    constructor (private router: Router){}

    cuts: string[] = ['Completo', 'Cabeça', 'Filé', 'Iscas']

    navigateToPurchase(): void {
        this.router.navigate(['/store/purchase']);
      }
}

