import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'clients-area-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class ClientsAreaTableComponent{
    
  constructor(private router: Router) { };

}
