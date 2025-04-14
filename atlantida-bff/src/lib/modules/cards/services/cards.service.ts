import { Injectable } from '@nestjs/common';
import axios from 'axios';
import { cardDto } from 'data-access/src/lib/dtos';
import { CardViewModel } from 'data-access/src/lib/view-models';
@Injectable()
export class CardsService {
  private apiUrl = 'https://atlantida-dad.onrender.com/cartoes';

  async getCards(): Promise<CardViewModel[]> {
    const response = await axios.get(this.apiUrl);

    return response.data.map((card: cardDto) => ({
      numeroCartao: card.numeroCartao,
      validade: card.validade, 
      cvv: card.cvv,
      tipo: card.tipo,
      bandeira: card.bandeira,
      clientId: card.clienteId
    }));
  }

  async addCard(card: CardViewModel): Promise<CardViewModel> {
    const response = await axios.post(this.apiUrl, {
      numeroCartao: card.numeroCartao,
      validade: card.validade, 
      cvv: card.cvv,
      tipo: card.tipo,
      bandeira: card.bandeira,
      clientId: card.clienteId
    });

    return response.data;
  }
}
