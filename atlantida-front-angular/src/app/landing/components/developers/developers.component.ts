import { Component } from '@angular/core';

@Component({
  selector: 'app-developers',
  templateUrl: './developers.component.html',
  styleUrl: './developers.component.css'
})
export class DevelopersComponent {
  devs = [
    {
      name: "Enzo Braz",
      imagePath: "/assets/images/tilapia.png"
    },
    {
      name: "Laura Melges",
      imagePath: "/assets/images/dev_laura.jpg"
    },
    {
      name: "Lucas Graças",
      imagePath: "/assets/images/dev_lucas.jpg"
    },
    {
      name: "Matheus D'addio",
      imagePath: "/assets/images/dev_matheus.jpg"
    }
  ];
}
