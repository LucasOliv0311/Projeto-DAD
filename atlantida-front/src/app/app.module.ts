import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { FooterComponent } from "./components/footer/footer.component";
import { HeaderComponent } from "./components/header/header.component";
import { BestOffersComponent } from "./pages/landing/components/best-offers/best-offers.component";
import { ClientSectionComponent } from "./pages/landing/components/client-section/client-section.component";
import { DevelopersComponent } from "./pages/landing/components/developers/developers.component";
import { InfoSectionComponent } from "./pages/landing/components/info-section/info-section.component";
import { InitialCardComponent } from "./pages/landing/components/initial-card/initial-card.component";
import { LandingComponent } from "./pages/landing/landing.component";
import { PurchaseInfoSectionComponent } from "./pages/purchase/components/info-section/info-section.component";
import { PurchaseMoreOffersComponent } from "./pages/purchase/components/more-offers/more-offers.component";
import { PurchaseProductInfoComponent } from "./pages/purchase/components/product-info/product-info.component";
import { PurchaseComponent } from "./pages/purchase/purchase.component";
import { ShopCartComponent } from './pages/shop-cart/shop-cart.component';
import { StoreFilterCategoriesComponent } from "./pages/store/components/filter/components/categories/categories.component";
import { StoreFilterCutsComponent } from "./pages/store/components/filter/components/cuts/cuts.component";
import { StoreFilterComponent } from "./pages/store/components/filter/filter.component";
import { StoreProductOptionsComponent } from "./pages/store/components/product-options/product-options.component";
import { StoreProductBoxComponent } from "./pages/store/components/products/components/product-box/product-box.component";
import { StoreProductsComponent } from "./pages/store/components/products/products.component";
import { StoreComponent } from "./pages/store/store.component";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LandingComponent,
    InitialCardComponent,
    BestOffersComponent,
    InfoSectionComponent,
    ClientSectionComponent,
    DevelopersComponent,
    StoreProductOptionsComponent,
    StoreComponent,
    StoreFilterComponent,
    StoreFilterCategoriesComponent,
    StoreFilterCutsComponent,
    StoreProductsComponent,
    StoreProductBoxComponent,
    ShopCartComponent,
    PurchaseComponent,
    PurchaseProductInfoComponent,
    PurchaseMoreOffersComponent,
    PurchaseInfoSectionComponent
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
