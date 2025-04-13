import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ClientService } from '../../../../services/clients/clients.service';

@Component({
  selector: 'atlantida-admin-space-clients-area-add-client',
  templateUrl: './add-client.component.html',
  styleUrl: './add-client.component.css'
})
export class AdminSpaceAddClientComponent {
  @ViewChild('modalComponent') modal!: ElementRef;

  clientForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private clientService: ClientService
  ){
    this.clientForm = this.fb.group({
      name: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      cpf: ['', Validators.required],
      phone: ['', Validators.required],
      address: ['', Validators.required]
    });
  };

  openModal() {
    this.modal.nativeElement.classList.add('ativo');
  }

  closeModal() {
    this.modal.nativeElement.classList.remove('ativo');
  }

  addClient(): void {
    if (this.clientForm.valid) {
      const clientData = this.clientForm.value;
      this.clientService.addClient(clientData).subscribe({
        next: () => {
          alert('Cliente adicionado com sucesso!');
          this.closeModal();
          this.clientForm.reset();
        },
        error: (err: HttpErrorResponse) => {
          console.error('Erro ao adicionar cliente:', err);
          alert('Erro ao adicionar cliente.');
        }
      });
    } else {
      alert('Preencha todos os campos corretamente.');
    }
  }
}
