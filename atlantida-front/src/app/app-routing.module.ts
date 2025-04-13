import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingComponent } from './pages/landing/landing.component';
import { ShopCartComponent } from './pages/shop-cart/shop-cart.component';
import { AuthGuard } from './guards/auth.guard';
import { PurchaseComponent } from './pages/purchase/purchase.component';

const routes: Routes = [
  { path: '', component: LandingComponent },
  { 
    path: 'store', 
    loadChildren: () => import('./pages/store/store.module').then(m => m.StoreModule),
    // canActivate: [AuthGuard]
  },
  { 
    path: 'register', 
    loadChildren: () => import('./pages/register/register.module').then(m => m.RegisterModule)
  },
  {
    path: 'shop-cart', component: ShopCartComponent,
    // canActivate: [AuthGuard]
  },
  { 
    path: 'admin-space', 
    loadChildren: () => import('./pages/admin-space/admin-space.module').then(m => m.AdminSpaceModule) 
  },
  {
    path: 'purchase/:id', component: PurchaseComponent,
    // canActivate: [AuthGuard]
  },
  {
    path: 'quantity/:id', component: PurchaseComponent,
    // canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
