import { Component } from '@angular/core';

@Component({
  selector: 'store-filter-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class StoreFilterCategoriesComponent {
    categories: string[] = ['Tilápia', 'Salmão', 'Camarão', 'Saint Peter']
}

