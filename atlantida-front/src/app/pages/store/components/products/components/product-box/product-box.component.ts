import { Component, Input } from '@angular/core';
import { AuthService } from '../../../../../../services/auth.service';
import { ItemViewModel } from '../../../../../../view-models/item.vm';
import { Router } from '@angular/router';

@Component({
  selector: 'store-products-product-box',
  templateUrl: './product-box.component.html',
  styleUrls: ['./product-box.component.css']
})
export class StoreProductBoxComponent {
  @Input() item!: ItemViewModel;
  cuts: string[] = ['Completo', 'Cabeça', 'Filé', 'Iscas'];

  constructor(
    private router: Router
  ) {};

  navigateToPurchase() {
    this.router.navigate(['store/purchase']);
    window.scrollTo(0, 0);
  };
}