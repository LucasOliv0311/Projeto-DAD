import { Injectable } from '@nestjs/common';
import axios from 'axios';
import { ClientDto } from 'data-access/src/lib/dtos';
import { UserViewModel } from 'data-access/src/lib/view-models/user.vm';

@Injectable()
export class LoginService {
  private apiUrl = "https://atlantida-dad.onrender.com/clientes";

  async getAll(): Promise<ClientDto[]>{
    const response = await axios.get(this.apiUrl);

    return response.data.map((client: ClientDto) => ({
        id: client.idCLiente,
        nome: client.nome,
        cpf: client.cpf,
        tel: client.telefone,
        email: client.email,
        endereco: client.endereco
    }));
  }

  async login(loginData: UserViewModel): Promise<ClientDto | undefined> {
    const allClients = await this.getAll();

    const client = allClients.find(client => client.email === loginData.email);

    return client;
  }
}