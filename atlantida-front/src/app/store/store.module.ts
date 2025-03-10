import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { StoreRoutingModule } from './store-routing.module';
import { StoreComponent } from './store.component';
import { StoreProductOptionsModule } from './components/product-options/product-options.module';
import { HeaderModule } from '../components/header/header.module';
import { StoreHeaderModule } from './components/header/header.module';

@NgModule({
  declarations: [
    StoreComponent,
  ],
  imports: [
    BrowserModule,
    StoreRoutingModule,
    StoreProductOptionsModule,
    StoreHeaderModule
  ],
  providers: [],
  bootstrap: [StoreComponent]
})
export class StoreModule { }
