import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { LandingModule } from './lib/modules/landing/landing.module';
import { StoreModule } from './lib/modules/store/store.module';
import { StoreController } from './lib/modules/store/controllers/store.controller';
import { StoreService } from './lib/modules/store/services/store.service';

@Module({
  imports: [LandingModule, StoreModule],
  controllers: [AppController, StoreController],
  providers: [AppService, StoreService],
})
export class AppModule {}
