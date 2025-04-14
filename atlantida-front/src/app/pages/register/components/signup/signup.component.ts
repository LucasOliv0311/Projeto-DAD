import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ClientViewModel, UserViewModel } from '../../../../view-models';
import { Router } from '@angular/router';
import { AuthService } from '../../../../services/auth/auth.service';
import { SignupService } from '../../../../services/register/signup/signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  form: FormGroup;
    
  constructor(
    private fb: FormBuilder,
    private router: Router,
    private authService: AuthService,
    private signupService: SignupService
  ) {
    this.form = this.fb.group({
      name: ['', Validators.required],
      email: ['', Validators.required],
      telefone: ['', Validators.required],
      cpf: ['', Validators.required],
      endereco: ['', Validators.required],
      password: ['', Validators.required],
      confPassword: ['', Validators.required],
    });
  };

  ngOnInit() {
    if (this.authService.getUserData() != null) {
      this.authService.logout();
    };
  };

  submit() {
    if (this.form.valid) {
      if (this.form.get('password')?.value === this.form.get('confPassword')?.value) {
        const userData: ClientViewModel = {
          nome: this.form.get('name')?.value,
          email: this.form.get('email')?.value,
          telefone: this.form.get('telefone')?.value,
          cpf: this.form.get('cpf')?.value,
          endereco: this.form.get('endereco')?.value,
          senha: this.form.get('password')?.value,
        };

        this.signupService.register(userData)
        .subscribe({
          next: () => {
            window.alert("Cadastro realizado com sucesso!");
            this.router.navigate(['register/login']);
            window.scrollTo(0, 0);
          },
          error: (err) => {
            console.error('Erro ao cadastrar:', err);
          }
        });
      } else {
      };
    } else {
    };
  };

  goToLogin() {
    this.router.navigate(['/register/login']);
    window.scrollTo(0, 0);
  };
}