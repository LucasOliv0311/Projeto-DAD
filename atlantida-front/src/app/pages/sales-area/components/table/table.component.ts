import { Component } from '@angular/core';
import { Router } from '@angular/router'
import { PedidoViewModel } from '../../../../view-models/pedido.vm';
import { SalesService } from '../../../../services/sales/sales.service';


@Component({
  selector: 'sales-area-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class SalesAreaTableComponent{
  orders: PedidoViewModel[] = [];
  constructor(
  private router: Router,
         private salesService: SalesService
       ) {}
     
       ngOnInit(): void {
         this.salesService.getAll().subscribe({
           next: (orders) => this.orders = orders,
           error: (error) => console.error('Erro ao carregar clientes:', error)
         });
       }
  
}
