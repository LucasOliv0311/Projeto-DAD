import { Component } from '@angular/core';

@Component({
  selector: 'store-products-product-box',
  templateUrl: './product-box.component.html',
  styleUrls: ['./product-box.component.css']
})
export class StoreProductBoxComponent {
    cuts: string[] = ['Completo', 'Cabeça', 'Filé', 'Iscas']
}

