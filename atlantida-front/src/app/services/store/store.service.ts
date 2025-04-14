import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductViewModel } from '../../view-models';

@Injectable({
  providedIn: 'root'
})
export class StoreService {
  private apiUrl = 'http://localhost:3000/store';

  constructor(private http: HttpClient) {}

  getProducts(): Observable<ProductViewModel[]> {
    return this.http.get<ProductViewModel[]>(`${this.apiUrl}/produto`);
  }
  
  addProduct(productData: ProductViewModel): Observable<any> {
      return this.http.post(`${this.apiUrl}/produto`, productData);
  }  
}
