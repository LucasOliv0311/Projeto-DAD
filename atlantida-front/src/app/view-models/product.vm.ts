export interface ProductViewModel {
    id: number,
    nome: string,
    descricao: string,
    tipo: string,
    preco: number,
    estoque: number,
    quantidade?: number
}