import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserViewModel } from '../../view-models';
import { PedidoViewModel } from '../../view-models/pedido.vm';

@Injectable({
  providedIn: 'root'
})
export class SalesService {
  private readonly apiUrl = `http://localhost:3000/pedido/pedidos`;

  constructor(private http: HttpClient) {}
  getAll(): Observable<PedidoViewModel[]> {
    return this.http.get<PedidoViewModel[]>(this.apiUrl);
  }
}
