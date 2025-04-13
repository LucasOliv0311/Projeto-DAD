import { Controller, Get, Param } from "@nestjs/common";
import { ShopCartService } from "../services/shop-cart.service";

@Controller('shopcart')
export class ShopCartController {
    constructor(private readonly shopCartService: ShopCartService) {};

    @Get('product/:id')
    async getProduct(@Param('id') id: number) {
        return this.shopCartService.getProduct("https://atlantida-dad.onrender.com/produto", id);
    }
}