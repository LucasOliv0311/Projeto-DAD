import { Injectable } from '@nestjs/common';
import axios from 'axios';
import { PedidoDTO } from 'data-access/src/lib/dtos/pedidoDto';
import { PedidoViewModel } from 'data-access/src/lib/view-models/pedido.vm';

@Injectable()
export class SalesService {
  private apiUrl = 'https://atlantida-dad.onrender.com/pedidos';

  async getOrders(): Promise<PedidoViewModel[]> {
    const response = await axios.get(this.apiUrl);

    return response.data.map((sales: PedidoDTO) => ({
      idPedido: sales.idPedido,
      idCliente: sales.idCliente,
      valorTotal: sales.valorTotal,
      idProduto: sales.idProduto,
      dataPedido: sales.dataPedido,
    }));
  }
}
