import { Controller, Get } from '@nestjs/common';
import { LandingService } from '../services/landing.service';
import { ProductViewModel } from 'data-access/src/lib/view-models';

@Controller('landing')
export class LandingController {
  constructor(private readonly landingService: LandingService) {}

  @Get('products')
  async getProducts(): Promise<ProductViewModel[]> {
    return this.landingService.getProducts();
  }
} 