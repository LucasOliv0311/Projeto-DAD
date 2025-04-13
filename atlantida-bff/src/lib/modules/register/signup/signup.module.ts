import { Module } from '@nestjs/common';
import { SignupController } from './controllers/signup.controller';
import { SignupService } from './services/signup.service';

@Module({
  controllers: [SignupController],
  providers: [SignupService],
})
export class SignupModule {}
