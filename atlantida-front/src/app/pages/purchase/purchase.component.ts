import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'atlantida-store-purchase',
  templateUrl: './purchase.component.html',
  styleUrl: './purchase.component.css'
})
export class PurchaseComponent {
  id!: number;

  constructor(
    private route: ActivatedRoute,
  ) {};

  ngOnInit() {
    this.id = Number.parseInt(this.route.snapshot.paramMap.get('id') ?? "0");
  };
}
