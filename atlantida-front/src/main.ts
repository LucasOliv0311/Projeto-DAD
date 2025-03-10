import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { LandingComponent } from './app/landing/landing.component';
import { HeaderComponent } from './app/components/header/header.component';
import { InitialCardComponent } from './app/landing/components/initial-card/initial-card.component';

platformBrowserDynamic().bootstrapModule(AppModule, {
  ngZoneEventCoalescing: true
})
  .catch(err => console.error(err));

platformBrowserDynamic().bootstrapModule(LandingComponent, {
  ngZoneEventCoalescing: true
})
  .catch(err => console.error(err));

platformBrowserDynamic().bootstrapModule(HeaderComponent, {
  ngZoneEventCoalescing: true
})
  .catch(err => console.error(err));

platformBrowserDynamic().bootstrapModule(InitialCardComponent, {
  ngZoneEventCoalescing: true
})
  .catch(err => console.error(err));