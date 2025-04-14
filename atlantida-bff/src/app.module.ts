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
import { SignupModule } from './lib/modules/register/signup/signup.module';
import { LoginModule } from './lib/modules/register/login/login.module';
import { PurchaseModule } from './lib/modules/purchase/purchase.module';
import { ShopCartModule } from './lib/modules/shop-cart/shop-cart.module';
import { CardsModule } from './lib/modules/cards/cards.module';
import { CardsController } from './lib/modules/cards/controllers/cards.controller';
import { CardsService } from './lib/modules/cards/services/cards.service';

@Module({
  imports: [LandingModule, SignupModule, LoginModule, PurchaseModule, ShopCartModule, StoreModule, ClientModule, SalesModule, CardsModule],
  controllers: [AppController, StoreController, ClientController, SalesController, CardsController],
  providers: [AppService, StoreService, ClientService, SalesService, CardsService],
})
export class AppModule {}
