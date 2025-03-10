import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { LandingComponent } from './landing/landing.component';
import { InitialCardComponent } from './landing/components/initial-card/initial-card.component';
import { BestOffersComponent } from './landing/components/best-offers/best-offers.component';
import { InfoSectionComponent } from './landing/components/info-section/info-section.component';
import { ClientSectionComponent } from './landing/components/client-section/client-section.component';
import { DevelopersComponent } from './landing/components/developers/developers.component';
import { FooterComponent } from './components/footer/footer.component';

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
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
