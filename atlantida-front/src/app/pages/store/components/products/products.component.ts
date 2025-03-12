import { Component } from '@angular/core';

@Component({
  selector: 'store-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class StoreProductsComponent {
    items = Array.from({ length: 9 });
}
