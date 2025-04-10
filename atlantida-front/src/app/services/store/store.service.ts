import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductViewModel } from '../../view-models';

@Injectable({
  providedIn: 'root'
})
export class StoreService {
  private apiUrl = 'http://localhost:3000/store/produto';

  constructor(private http: HttpClient) {}

  getProducts(): Observable<ProductViewModel[]> {
    console.log('oi')
    return this.http.get<ProductViewModel[]>(this.apiUrl);
  }
}
