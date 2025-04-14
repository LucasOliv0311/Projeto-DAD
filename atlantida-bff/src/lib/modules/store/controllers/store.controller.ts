import { Body, Controller, Get, Post } from '@nestjs/common';
import { StoreService } from '../services/store.service';
import { ProductViewModel } from 'data-access/src/lib/view-models';

@Controller('store')
export class StoreController {
  constructor(private readonly storeService: StoreService) {}

  @Get('produto')
  async getProducts(): Promise<ProductViewModel[]> {
    return this.storeService.getProducts();
  }

  @Post('produto')
    async addClient(@Body() product: ProductViewModel): Promise<ProductViewModel> {
      return this.storeService.addProduct(product);
    }
}