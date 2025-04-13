import { Controller, Get, Param } from "@nestjs/common";
import { PurchaseService } from "../services/purchase.service";

@Controller('purchase')
export class PurchaseController {
    constructor(
        private readonly purchaseService: PurchaseService,
    ) {};

    @Get('product/:id')
    async getProduct(@Param('id') id: number) {
        return this.purchaseService.getProduct("https://atlantida-dad.onrender.com/produto", id);
    }

    @Get('quantity/:id')
    async getQuantity(@Param('id') id: number) {
        return this.purchaseService.getQuantity("https://atlantida-dad.onrender.com/carrinhos", id);
    }
}