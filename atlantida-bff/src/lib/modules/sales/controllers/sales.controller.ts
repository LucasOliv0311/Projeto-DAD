import { Controller, Get } from '@nestjs/common';
import { UserViewModel } from 'data-access/src/lib/view-models';
import { SalesService } from '../services/sales.service';
import { PedidoViewModel } from 'data-access/src/lib/view-models/pedido.vm';

@Controller('pedido')
export class SalesController {
  constructor(private readonly salesService: SalesService) {}

  @Get('pedidos')
  async getClients(): Promise<PedidoViewModel[]> {
    return this.salesService.getOrders();
  }
}
