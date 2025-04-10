import { Component, OnInit } from '@angular/core';
import { ProductViewModel } from '../../../../view-models';
import { StoreService } from '../../../../services';

@Component({
  selector: 'store-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class StoreProductsComponent implements OnInit {
  constructor(private service: StoreService) {}

  items: ProductViewModel[] = [];
  count = 9;

  ngOnInit(): void {
    console.log('chamando requisição getProducts');
    this.service.getProducts().subscribe({
      next: (data) => {
        console.log(data);
        this.items = data;
      },
      error: (err) => console.error('Erro ao buscar produtos:', err),
    });
  }

  showMore(): void {
    this.count += 9;
  }

  get visibleItems(): ProductViewModel[] {
    return this.items.slice(0, this.count);
  }
}
