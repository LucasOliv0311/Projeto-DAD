import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductViewModel } from '../../view-models/product.vm'

@Injectable({
  providedIn: 'root',
})
export class LandingService {
  private apiUrl = '/landing/products';

  constructor(private http: HttpClient) {}

  getProducts(): Observable<ProductViewModel[]> {
    return this.http.get<ProductViewModel[]>(this.apiUrl);
  }
}