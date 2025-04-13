import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserViewModel } from '../../view-models';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private readonly apiUrl = `http://localhost:3000/client`;

  constructor(private http: HttpClient) {}

  getAll(): Observable<UserViewModel[]> {
    return this.http.get<UserViewModel[]>(`${this.apiUrl}/clientes`);
  }

  addClient(clientData: UserViewModel): Observable<any> {
    console.log(clientData)
    return this.http.post(`${this.apiUrl}/clientes`, clientData);
  }  
}