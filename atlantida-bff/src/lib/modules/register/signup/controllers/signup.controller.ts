import { Body, Controller, Post } from '@nestjs/common';
import { SignupService } from '../services/signup.service';
import { ClientDto } from 'data-access/src/lib/dtos';

@Controller('signup')
export class SignupController {
  constructor(private readonly signupService: SignupService) {}

  @Post('register')
  async signup(@Body() body: ClientDto) {
    return this.signupService.signup(body);
  }
}