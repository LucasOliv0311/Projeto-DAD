import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProductViewModel } from '../../../../view-models';
import { StoreService } from '../../../../services';

@Component({
  selector: 'products-area-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class ProductsAreaTableComponent {
  products: ProductViewModel[] = [];

  constructor(private productService: StoreService) {}

  ngOnInit(): void {
    this.productService.getProducts().subscribe({
      next: (products) => (this.products = products),
      error: (error) => console.error('Erro ao carregar clientes:', error),
    });
  }
}
