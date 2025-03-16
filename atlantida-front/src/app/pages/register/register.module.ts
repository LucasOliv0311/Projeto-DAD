import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { LoginComponent } from "./components/login/login.component";
import { SignupComponent } from './components/signup/signup.component';
import { RegisterRoutingModule } from "./register-routing.module";
import { RegisterComponent } from "./register.component";

@NgModule({
    declarations: [
        RegisterComponent,
        LoginComponent,
        SignupComponent
    ],
    imports: [
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        RegisterRoutingModule,
    ],
    providers: [],
})

export class RegisterModule {}