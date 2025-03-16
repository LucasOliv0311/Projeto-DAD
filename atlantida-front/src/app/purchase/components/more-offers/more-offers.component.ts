import { Component } from '@angular/core';

@Component({
  selector: 'atlantida-purchase-more-offers',
  templateUrl: './more-offers.component.html',
  styleUrl: './more-offers.component.css'
})
export class PurchaseMoreOffersComponent {
    items = [
        {
          name: "Tilápia Fresca",
          price: 64.99,
          imagePath: "/assets/images/tilapia.png"
        },
        {
          name: "Camarão",
          price: 49.99,
          imagePath: "/assets/images/camarao.png"
        },
        {
          name: "Filé de Salmão",
          price: 54.99,
          imagePath: "/assets/images/salmao.png"
        },
        {
          name: "Sardinha",
          price: 29.99,
          imagePath: "/assets/images/sardinha.jpg"
        }
      ];
}
