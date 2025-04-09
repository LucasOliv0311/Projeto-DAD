export class ItemDto {
    id: number;
    name: string;
    price: number;
    quantity: number;
    image: string;
  
    constructor(entity: any) {
      this.id = entity.id;
      this.name = entity.name;
      this.price = entity.price;
      this.quantity = entity.quantity;
      this.image = entity.image;
    }
  }
  