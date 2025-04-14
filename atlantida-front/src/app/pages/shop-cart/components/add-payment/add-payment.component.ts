import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CardService } from '../../../../services/cards/cards.service';

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
    private cardService: CardService
  ){
    this.cardForm = this.fb.group({
      numeroCartao: ['', Validators.required],
      validade: ['', Validators.required],
      cvv: ['', Validators.required],
      bandeira: ['', Validators.required],
      tipo: ['', Validators.required],
      clientId: ['', Validators.required]
    });
  };

  openModal() {
    this.modal.nativeElement.classList.add('ativo');
  }

  closeModal() {
    this.modal.nativeElement.classList.remove('ativo');
  }

  addPaymentWay(): void {
    if (this.cardForm.valid) {
      const cardData = this.cardForm.value;
      this.cardService.addCard(cardData).subscribe({
        next: () => {
          alert('Cartão adicionado com sucesso!');
          this.closeModal();
          this.cardForm.reset();
        },
        error: (err: HttpErrorResponse) => {
          alert('Cartão Inserido com Sucesso!');
        }
      });
    } else {
      alert('Preencha todos os campos corretamente.');
    }
  }
}
