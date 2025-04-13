import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { ItemViewModel } from '../../../../../../view-models';

@Component({
  selector: 'store-products-product-box',
  templateUrl: './product-box.component.html',
  styleUrls: ['./product-box.component.css']
})
export class StoreProductBoxComponent {
  @Input() item!: ItemViewModel;
  cuts: string[] = ['Completo', 'Cabeça', 'Filé', 'Iscas'];

    constructor (private router: Router){}

    navigateToPurchase(itemId: number) {
      this.router.navigate(['purchase', itemId]);
      window.scrollTo(0, 0);
    };
}