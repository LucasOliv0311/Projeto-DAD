import { Controller, Get } from '@nestjs/common';
import { LandingService } from '../services/landing.service';

@Controller('landing')
export class LandingController {
  constructor(private readonly landingService: LandingService) {};

  @Get('products')
  async getProducts() {
    return this.landingService.getProducts();
  }
}