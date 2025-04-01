import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-space',
  templateUrl: './admin-space.component.html',
  styleUrls: ['./admin-space.component.css']
})
export class AdminSpaceComponent {
    quickAccess= [
      {
          imgPath: '/assets/images/icone-pessoas.png',
          title: 'Área dos Clientes', 
          description: 'Acesse a área dos clientes para controlar as movimentações e adicionar novos clientes',
          pathRoute: '/admin-space/clients-area'
      },
      {
        imgPath: '/assets/images/icone-produtos.png',
        title: 'Área dos Produtos', 
        description: 'Acesse a área dos produtos para controlar as movimentações e adicionar novos produtos',
        pathRoute: '/admin-space/products-area'
      },
      {
        imgPath: '/assets/images/icone-vendas.png',
        title: 'Área de Vendas', 
        description: 'Acesse a área das vendas para controlar as movimentações do caixa',
        pathRoute: '/admin-space/sales-area'
      }, 
    ]
}
