import { Module } from '@nestjs/common';
import { ClientController } from './controllers/clients.controller';
import { ClientService } from './services/clients.service';

@Module({
  controllers: [ClientController],
  providers: [ClientService],
})
export class ClientModule {}
