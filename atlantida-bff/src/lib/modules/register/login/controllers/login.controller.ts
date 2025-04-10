import { Body, Controller, Post } from '@nestjs/common';
import { LoginService } from '../services/login.service';
import { UserViewModel } from 'data-access/src/lib/view-models/user.vm';

@Controller('login')
export class LoginController {
  constructor(private readonly loginService: LoginService) {}

  @Post('get-account')
  async login(@Body() loginData: UserViewModel) {
    return await this.loginService.login(loginData);
  }
}