import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserViewModel } from '../../../../view-models';
import { ClientService } from '../../../../services/clients/clients.service';

@Component({
  selector: 'clients-area-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class ClientsAreaTableComponent implements OnInit {
  clients: UserViewModel[] = [];

  constructor(
    private router: Router,
    private clientService: ClientService
  ) {}

  ngOnInit(): void {
    this.clientService.getAll().subscribe({
      next: (clients) => this.clients = clients,
      error: (error) => console.error('Erro ao carregar clientes:', error)
    });
  }
}
