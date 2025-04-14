import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ClientService } from '../../../../services/clients/clients.service';

@Component({
  selector: 'atlantida-shop-cart-add-payment',
  templateUrl: './add-payment.component.html',
  styleUrl: './add-payment.component.css'
})
export class ShopCartAddPaymentComponent {
  @ViewChild('modalComponent') modal!: ElementRef;

  cardForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private clientService: ClientService
  ){
    this.cardForm = this.fb.group({
      numeroCartao: ['', Validators.required],
      validade: ['', [Validators.required, Validators.email]],
      cvv: ['', Validators.required],
      bandeira: ['', Validators.required],
      tipo: ['', Validators.required],
      clienteId: ['', Validators.required]
    });
  };

  openModal() {
    this.modal.nativeElement.classList.add('ativo');
  }

  closeModal() {
    this.modal.nativeElement.classList.remove('ativo');
  }

  addClient(): void {
    if (this.cardForm.valid) {
      const clientData = this.cardForm.value;
      this.clientService.addClient(clientData).subscribe({
        next: () => {
          alert('Cliente adicionado com sucesso!');
          this.closeModal();
          this.cardForm.reset();
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
