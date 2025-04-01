import { Component } from '@angular/core';
import { loginViewModel, UserViewModel } from './view-models';
import { AuthService } from './services/auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'atlantida-front';

  registeredUser: boolean = false;
  userData: UserViewModel | null = null;

  constructor(private authService: AuthService) {}

  ngOnInit() {
    this.authService.user$.subscribe(data => {
      if (data) {
        this.userData = data;
      };
    });
  };
}
