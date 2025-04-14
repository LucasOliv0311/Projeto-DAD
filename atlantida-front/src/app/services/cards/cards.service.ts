import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CardViewModel, UserViewModel } from '../../view-models';

@Injectable({
  providedIn: 'root'
})
export class CardService {
  private readonly apiUrl = `http://localhost:3000/cards`;

  constructor(private http: HttpClient) {}

  getAll(): Observable<CardViewModel[]> {
    return this.http.get<CardViewModel[]>(`${this.apiUrl}/cartoes`);
  }

  addCard(cardData: CardViewModel): Observable<any> {
    return this.http.post(`${this.apiUrl}/cartoes`, cardData);
  }  
}