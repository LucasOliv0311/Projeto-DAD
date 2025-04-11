import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { LandingModule } from './lib/modules/landing/landing.module';
import { SignupModule } from './lib/modules/register/signup/signup.module';
import { LoginModule } from './lib/modules/register/login/login.module';
import { PurchaseModule } from './lib/modules/purchase/purchase.module';
import { ShopCartModule } from './lib/modules/shop-cart/shop-cart.module';

@Module({
  imports: [LandingModule, SignupModule, LoginModule, PurchaseModule, ShopCartModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
