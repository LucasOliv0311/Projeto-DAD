import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StoreService } from '../../../../services';

@Component({
  selector: 'atlantida-admin-space-products-area-add-product',
  templateUrl: './add-product.component.html',
  styleUrl: './add-product.component.css'
})
export class AdminSpaceAddProductComponent {
  @ViewChild('modalComponent') modal!: ElementRef;

  productForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private storeService: StoreService
  ){
    this.productForm = this.fb.group({
      nome: ['', Validators.required],
      descricao: ['', Validators.required],
      tipo: ['', Validators.required],
      preco: ['', Validators.required],
      estoque: ['', Validators.required],
      imagem: ['', Validators.required],
    });
  };

  openModal() {
    this.modal.nativeElement.classList.add('ativo');
  }

  closeModal() {
    this.modal.nativeElement.classList.remove('ativo');
  }

  addProduct(): void {
    console.log(this.productForm.value);
    if (this.productForm.valid) {
      const productData = this.productForm.value;
      this.storeService.addProduct(productData).subscribe({
        next: () => {
          alert('Cliente adicionado com sucesso!');
          this.closeModal();
          this.productForm.reset();
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
