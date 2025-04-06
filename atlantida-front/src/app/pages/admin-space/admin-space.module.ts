import { NgModule } from "@angular/core";
import { AdminSpaceComponent } from "./admin-space.component";
import { CommonModule } from "@angular/common";
import { Routes, RouterModule } from "@angular/router";
import { AdminSpaceClientsAreaComponent } from "../clients-area/clients-area.component";
import { AdminSpaceProductsAreaComponent } from "../products-area/products-area.component";
import { AdminSpaceSalesAreaComponent } from "../sales-area/sales-area.component";

const routes: Routes = [
  { path: '', component: AdminSpaceComponent },
  { path: 'clients-area', component: AdminSpaceClientsAreaComponent},
  { path: 'products-area', component: AdminSpaceProductsAreaComponent},
  { path: 'sales-area', component: AdminSpaceSalesAreaComponent},

];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes) // Importa as rotas do módulo
  ]
})
export class AdminSpaceModule {};