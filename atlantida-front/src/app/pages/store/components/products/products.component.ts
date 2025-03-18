import { Component } from '@angular/core';
import { ItemViewModel } from '../../../../view-models/item.vm';

@Component({
  selector: 'store-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class StoreProductsComponent {
  items: ItemViewModel[] = [
    {
      id: 0,
      name: "Tilápia Fresca",
      price: 64.99,
      quantity: 1,
      image: "/assets/images/tilapia.png"
    },
    {
      id: 1,
      name: "Camarão",
      price: 49.99,
      quantity: 1,
      image: "/assets/images/camarao.png"
    },
    {
      id: 2,
      name: "Filé de Salmão",
      price: 54.99,
      quantity: 1,
      image: "/assets/images/salmao.png"
    },
    {
      id: 3,
      name: "Sardinha",
      price: 29.99,
      quantity: 1,
      image: "/assets/images/sardinha.jpg"
    }
  ];
}