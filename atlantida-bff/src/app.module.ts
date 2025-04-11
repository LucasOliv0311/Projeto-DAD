import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { LandingModule } from './lib/modules/landing/landing.module';
import { StoreModule } from './lib/modules/store/store.module';
import { StoreController } from './lib/modules/store/controllers/store.controller';
import { StoreService } from './lib/modules/store/services/store.service';
import { ClientModule } from './lib/modules/clients/clients.module';
import { ClientController } from './lib/modules/clients/controllers/clients.controller';
import { ClientService } from './lib/modules/clients/services/clients.service';
import { SalesModule } from './lib/modules/sales/sales.module';
import { SalesController } from './lib/modules/sales/controllers/sales.controller';
import { SalesService } from './lib/modules/sales/services/sales.service';

@Module({
  imports: [LandingModule, StoreModule, ClientModule, SalesModule],
  controllers: [AppController, StoreController, ClientController, SalesController],
  providers: [AppService, StoreService, ClientService, SalesService],
})
export class AppModule {}
