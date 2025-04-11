import { Injectable } from '@nestjs/common';
import axios from 'axios';
import { productDto } from 'data-access/src/lib/dtos/productDto';

@Injectable()
export class LandingService {
  private apiUrl = "https://atlantida-dad.onrender.com/produto";

  async getProducts() {
    const response = await axios.get(this.apiUrl);

    return response.data.map((product: productDto) => ({
      id: product.idProduto,
      nome: product.nome,
      descricao: product.descricao,
      tipo: product.tipo,
      preco: product.preco,
      estoque: product.estoque
    }));
  }
}
