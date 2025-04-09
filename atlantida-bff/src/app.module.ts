import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { LandingModule } from './lib/modules/landing/landing.module';

@Module({
  imports: [LandingModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
