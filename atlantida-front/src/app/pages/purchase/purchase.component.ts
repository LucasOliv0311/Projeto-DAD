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
    this.route.paramMap.subscribe(params => {
      this.id = Number(params.get('id') ?? "0");
      console.log("ID atualizado:", this.id);
    });
  };
}
