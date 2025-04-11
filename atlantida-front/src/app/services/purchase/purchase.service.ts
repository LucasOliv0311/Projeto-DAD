import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { ProductViewModel } from "../../view-models";

@Injectable({
    providedIn: 'root',
})
export class PurchaseService {
    private apiUrl = "/purchase/product";

    constructor(private http: HttpClient) {};

    async getProduct(id: number) {
        return this.http.get<ProductViewModel>(`${this.apiUrl}/${id}`);
    }
}