import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { CartViewModel, ProductViewModel } from "../../view-models";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root',
})
export class PurchaseService {
    private apiUrl = "/purchase";

    constructor(private http: HttpClient) {};

    getProduct(id: number) {
        return this.http.get<ProductViewModel>(`${this.apiUrl}/product/${id}`);
    }

    getQuantity(id: number): Observable<CartViewModel> {
        return this.http.get<CartViewModel>(`${this.apiUrl}/quantity/${id}`);
    }
}