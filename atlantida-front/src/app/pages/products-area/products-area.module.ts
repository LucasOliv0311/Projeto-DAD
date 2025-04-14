import { NgModule } from '@angular/core';
import { AdminSpaceProductsAreaComponent } from './products-area.component';
import { CommonModule } from '@angular/common';
import { AdminSpaceAddProductComponent } from './components/add-product/add-product.component';

@NgModule({
  declarations: [AdminSpaceProductsAreaComponent],
  imports: [
    CommonModule,
    AdminSpaceAddProductComponent
  ],
  providers: [],
})
export class AdminSpaceProductsAreaModule { }
