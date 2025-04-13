import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { ProductViewModel } from "../../view-models";

@Injectable({
    providedIn: 'root',
})
export class ShopCartService {
    private apiUrl = "/shopcart";

    constructor(private http: HttpClient) {};

    getProduct(id: number) {
        return this.http.get<ProductViewModel>(`${this.apiUrl}/product/${id}`);
    }
}