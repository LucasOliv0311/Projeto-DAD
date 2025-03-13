import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingComponent } from './pages/landing/landing.component';
import { StoreComponent } from './pages/store/store.component';
import { ShopCartComponent } from './pages/shop-cart/shop-cart.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: '', component: LandingComponent },
  { path: 'store', component: StoreComponent },
  { 
    path: 'register', 
    loadChildren: () => import('./pages/register/register.module').then(m => m.RegisterModule) 
  },
  { path: 'shop-cart', component: ShopCartComponent, canActivate: [AuthGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
