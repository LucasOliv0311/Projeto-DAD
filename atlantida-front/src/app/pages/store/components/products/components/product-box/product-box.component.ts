import { Component, Input } from '@angular/core';
import { AuthService } from '../../../../../../services/auth.service';
import { ItemViewModel } from '../../../../../../view-models/item.vm';

@Component({
  selector: 'store-products-product-box',
  templateUrl: './product-box.component.html',
  styleUrls: ['./product-box.component.css']
})
export class StoreProductBoxComponent {
  @Input() item!: ItemViewModel;
  cuts: string[] = ['Completo', 'Cabeça', 'Filé', 'Iscas'];

  constructor(private authService: AuthService) {};

  addToShopCart() {
    this.authService.addToShopCart(this.item);
  };
}