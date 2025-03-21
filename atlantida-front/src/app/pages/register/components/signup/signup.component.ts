import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserViewModel } from '../../../../view-models';
import { Router } from '@angular/router';
import { AuthService } from '../../../../services/auth.service';

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
    private authService: AuthService
  ) {
    this.form = this.fb.group({
      name: ['', Validators.required],
      email: ['', Validators.required],
      tel: ['', Validators.required],
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
        const userData: UserViewModel = {
          nome: this.form.get('name')?.value,
          email: this.form.get('email')?.value,
          tel: this.form.get('tel')?.value,
          cpf: this.form.get('cpf')?.value,
          endereco: this.form.get('endereco')?.value,
          password: this.form.get('password')?.value,
        };

        window.alert("Cadastro realizado com sucesso!");
        this.authService.signup(userData);
        this.router.navigate(['register/login']);
        window.scrollTo(0, 0);
      } else {
        console.log("senha inválida");
      };
    } else {
      console.log("form inválido");
    };
  };

  goToLogin() {
    this.router.navigate(['/register/login']);
    window.scrollTo(0, 0);
  };
}