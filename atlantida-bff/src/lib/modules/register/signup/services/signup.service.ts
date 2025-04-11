import { Injectable } from '@nestjs/common';
import axios from 'axios';
import { ClientDto } from 'data-access/src/lib/dtos';

@Injectable()
export class SignupService {
  private apiUrl = "https://atlantida-dad.onrender.com/clientes";

  async signup(body: ClientDto) {
    const response = await axios.post(this.apiUrl, body);

    return response.data;
  }
}
