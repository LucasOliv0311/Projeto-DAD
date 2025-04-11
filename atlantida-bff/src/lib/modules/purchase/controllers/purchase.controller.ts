import { Controller, Get } from "@nestjs/common";
import { PurchaseService } from "../services/purchase.service";

@Controller('purchase')
export class PurchaseController {
    constructor(private readonly purchaseService: PurchaseService) {};

    @Get('product')
    async getProduct(id: number) {
        return this.purchaseService.getProduct(id);
    }
}