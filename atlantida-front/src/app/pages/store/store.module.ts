import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { StoreComponent } from './store.component';
import { PurchaseComponent } from '../purchase/purchase.component';

const routes: Routes = [
  { path: '', component: StoreComponent },
  { path: 'purchase', component: PurchaseComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class StoreModule { }
