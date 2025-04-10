import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ClientViewModel } from '../../../view-models';

@Injectable({
  providedIn: 'root',
})
export class SignupService {
  private apiUrl = '/signup/register';

  constructor(private http: HttpClient) {}

  register(body: ClientViewModel) {
    return this.http.post(this.apiUrl, body);
  }
}