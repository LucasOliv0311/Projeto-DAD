import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { loginViewModel, UserViewModel } from '../../../../view-models';
import { AuthService } from '../../../../services/auth.service';

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
    private authService: AuthService
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
    console.log(this.authService.getUsersData());
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

      this.authService.login(userData);
      this.router.navigate(['']);
    };
  };

  goToSignup() {
    this.router.navigate(['/register/signup']);
    window.scrollTo(0, 0);
  };

  deleteUsers() {
    this.authService.deleteUsers();
  };
}
