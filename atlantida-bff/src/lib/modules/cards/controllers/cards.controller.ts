import { Body, Controller, Get, Post } from '@nestjs/common';
import { CardViewModel } from 'data-access/src/lib/view-models';
import { CardsService } from '../services/cards.service';

@Controller('cards')
export class CardsController {
  constructor(private readonly cardsService: CardsService) {}

  @Get('cartoes')
  async getCards(): Promise<CardViewModel[]> {
    return this.cardsService.getCards();
  }

  @Post('cartoes')
  async addCard(@Body() card: CardViewModel): Promise<CardViewModel> {
    return this.cardsService.addCard(card);
  }
}
