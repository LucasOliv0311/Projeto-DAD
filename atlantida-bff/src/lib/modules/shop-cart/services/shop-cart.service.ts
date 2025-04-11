import { Injectable } from "@nestjs/common";
import axios from "axios";
import { productDto } from "data-access/src/lib/dtos";

@Injectable()
export class ShopCartService {
    private apiUrl = "https://atlantida-dad.onrender.com/produto";

    async getProduct(id: number) {
        const response = await axios.get(`${this.apiUrl}/${id}`);
        const product: productDto = response.data;

        return {
            id: product.idProduto,
            nome: product.nome,
            descricao: product.descricao,
            tipo: product.tipo,
            preco: product.preco,
            estoque: product.estoque
        };
    }
}