import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserViewModel } from '../../../view-models';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private apiUrl = '/login/get-account';

  constructor(private http: HttpClient) {}

  login(body: UserViewModel) {
    return this.http.post(this.apiUrl, body);
  }
}