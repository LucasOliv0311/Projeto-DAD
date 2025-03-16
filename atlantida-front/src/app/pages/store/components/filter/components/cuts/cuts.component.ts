import { Component } from '@angular/core';

@Component({
  selector: 'store-filter-cuts',
  templateUrl: './cuts.component.html',
  styleUrls: ['./cuts.component.css']
})
export class StoreFilterCutsComponent {
    cuts: string[] = ['Completo', 'Cabeça', 'Filé', 'Iscas']
}

