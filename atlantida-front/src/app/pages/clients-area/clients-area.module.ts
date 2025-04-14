import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AdminSpaceClientsAreaComponent } from './clients-area.component';
import { AdminSpaceAddClientComponent } from './components/add-client/add-client.component';

const routes: Routes = [
  { path: '', component: AdminSpaceClientsAreaComponent },
];

@NgModule({
  declarations: [
    AdminSpaceClientsAreaComponent,
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    AdminSpaceAddClientComponent,
  ]
})
export class AdminSpaceClientsAreaModule {}
