import { Module } from '@nestjs/common';
import { LandingService } from './services/landing.service';
import { LandingController } from './controllers/landing.controller';

@Module({
  controllers: [LandingController],
  providers: [LandingService],
})
export class LandingModule {}
