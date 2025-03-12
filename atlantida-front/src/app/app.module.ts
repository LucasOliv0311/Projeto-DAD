import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { BestOffersComponent } from './pages/landing/components/best-offers/best-offers.component';
import { ClientSectionComponent } from './pages/landing/components/client-section/client-section.component';
import { DevelopersComponent } from './pages/landing/components/developers/developers.component';
import { InfoSectionComponent } from './pages/landing/components/info-section/info-section.component';
import { InitialCardComponent } from './pages/landing/components/initial-card/initial-card.component';
import { LandingComponent } from './pages/landing/landing.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LandingComponent,
    InitialCardComponent,
    BestOffersComponent,
    InfoSectionComponent,
    ClientSectionComponent,
    DevelopersComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
