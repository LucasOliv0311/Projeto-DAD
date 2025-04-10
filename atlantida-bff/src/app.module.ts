import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { LandingModule } from './lib/modules/landing/landing.module';
import { SignupModule } from './lib/modules/register/signup/signup.module';
import { LoginModule } from './lib/modules/register/login/login.module';

@Module({
  imports: [LandingModule, SignupModule, LoginModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
