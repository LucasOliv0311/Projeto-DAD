import { Component, Input, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';

interface QuickAccessItem {
  imgPath: string;
  title: string;
  description: string;
  pathRoute: string
}

@Component({
  selector: 'admin-space-quick-access',
  templateUrl: './quick-access.component.html',
  styleUrls: ['./quick-access.component.css']
})
export class AdminSpaceQuickAccessComponent implements OnInit{
  constructor(private router: Router){};

  @Input() quickAccess: QuickAccessItem[] = [];  arraySize = 0;

  ngOnInit(): void {
    this.arraySize = this.quickAccess.length;
  }

  navigateToArea(index: number): void {
    if (this.quickAccess[index]) {
      this.router.navigate([this.quickAccess[index].pathRoute]);
      window.scrollTo(0, 0);
    }
  }

}
