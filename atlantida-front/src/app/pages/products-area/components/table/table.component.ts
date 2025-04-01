import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'products-area-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class ProductsAreaTableComponent{
    constructor(private router: Router) { };
  
}
