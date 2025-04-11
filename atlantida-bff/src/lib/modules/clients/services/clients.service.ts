import { Injectable } from '@nestjs/common';
import axios from 'axios';
import { ClientDto } from 'data-access/src/lib/dtos/clientDto';
import { UserViewModel } from 'data-access/src/lib/view-models/user.vm';

@Injectable()
export class ClientService {
  private apiUrl = 'https://atlantida-dad.onrender.com/clientes';

  async getClients(): Promise<UserViewModel[]> {
    const response = await axios.get(this.apiUrl);

    return response.data.map((client: ClientDto) => ({
      id: client.idCliente,
      nome: client.nome,
      email: client.email,
      cpf: client.cpf,
      telefone: client.telefone,
      endereco: client.endereco
    }));
  }
}
