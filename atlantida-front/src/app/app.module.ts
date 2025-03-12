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
import { StoreProductOptionsComponent } from './store/components/product-options/product-options.component';
import { StoreComponent } from './store/store.component';
import { StoreFilterComponent } from './store/components/filter/filter.component';
import { StoreFilterCategoriesComponent } from './store/components/filter/components/categories/categories.component';
import { StoreFilterCutsComponent } from './store/components/filter/components/cuts/cuts.component';
import { StoreProductsComponent } from './store/components/products/products.component';
import { StoreProductBoxComponent } from './store/components/products/components/product-box/product-box.component';

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
    StoreProductOptionsComponent,
    StoreComponent,
    FooterComponent,
    StoreFilterComponent,
    StoreFilterCategoriesComponent,
    StoreFilterCutsComponent,
    StoreProductsComponent,
    StoreProductBoxComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }