import { Component } from '@angular/core';
import { Developers } from '../../../../interfaces/Developers';

@Component({
  selector: 'app-developers',
  templateUrl: './developers.component.html',
  styleUrl: './developers.component.css'
})
export class DevelopersComponent {
  devs: Developers[] = [
    {
      name: "Enzo Braz",
      imagePath: "/assets/images/dev_enzo.jpg"
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