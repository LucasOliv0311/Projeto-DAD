import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingComponent } from './landing/landing.component';
import { StoreComponent } from './store/store.component';

const routes: Routes = [
  {path: '', component: LandingComponent},
  {path: 'store', component: StoreComponent}
  // {path: 'login', component: }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
