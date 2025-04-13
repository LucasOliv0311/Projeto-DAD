import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { loginViewModel, UserViewModel } from '../../../../view-models';
import { AuthService } from '../../../../services/auth/auth.service';
import { LoginService } from '../../../../services/register/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private authService: AuthService,
    private loginService: LoginService
  ) {
    this.form = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  };

  ngOnInit() {
    if (this.authService.getUserData() != null) {
      this.authService.logout();
    };
  };

  submit() {
    if (this.form.valid) {
      const userData: UserViewModel = {
        nome: '',
        cpf: '',
        endereco: '',
        tel: '',
        email: this.form.get('email')?.value,
        password: this.form.get('password')?.value,
      }

      this.loginService.login(userData).subscribe({
        next: (data) => {
          if (!data) {
            console.error("usuário não encontrado")
          };
          this.router.navigate(['']);
          this.authService.login(userData);
        },
        error: (err) => {
          console.error("erro na requisição: ", err);
        }
      })
    };
  };

  goToSignup() {
    this.router.navigate(['/register/signup']);
    window.scrollTo(0, 0);
  };
}