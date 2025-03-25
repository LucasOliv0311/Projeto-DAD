import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'sales-area-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class SalesAreaTableComponent{
    constructor(private router: Router) { };
  
}
