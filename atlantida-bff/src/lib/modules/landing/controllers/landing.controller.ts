import { Controller, Get } from '@nestjs/common';
import { LandingService } from '../services/landing.service';
import { productDto } from 'data-access/src/lib/dtos';

@Controller('landing')
export class LandingController {
  constructor(private readonly landingService: LandingService) {};

  @Get('products')
  async getProducts(): Promise<productDto[]> {
    return (await this.landingService.getProducts()).slice(0, 4);
  }
}