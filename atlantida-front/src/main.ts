import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { provideHttpClient } from '@angular/common/http';
import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { AppModule } from './app/app.module';

platformBrowserDynamic().bootstrapModule(AppModule, {
  ngZoneEventCoalescing: true
})
  .catch(err => console.error(err));

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient()
  ]
})
  .catch(err => console.error(err));