import { Injectable } from "@nestjs/common";
import axios from "axios";

@Injectable()
export class PurchaseService {
    async getProduct(apiUrl: string, id: number) {
        const response = await axios.get(`${apiUrl}/${id}`);
        const product = response.data;

        return {
            id: product.idProduto,
            nome: product.nome,
            descricao: product.descricao,
            tipo: product.tipo,
            preco: product.preco,
            estoque: product.estoque
        };
    }

    async getQuantity(apiUrl: string, id: number) {
        const response = await axios.get(`${apiUrl}/${id}`);
        return response.data;
    }
}