import { Controller, Get } from '@nestjs/common';
import { UserViewModel } from 'data-access/src/lib/view-models';
import { ClientService } from '../services/clients.service';

@Controller('client')
export class ClientController {
  constructor(private readonly clientService: ClientService) {}

  @Get('clientes')
  async getClients(): Promise<UserViewModel[]> {
    return this.clientService.getClients();
  }
}
