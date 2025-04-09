import { ProductDto } from "../dtos";
import { ItemViewModel } from "../vms";


export class ProductAdapter {
  static fromDto(dto: ProductDto): ItemViewModel {
    return {
      id: dto.id,
      name: dto.title,
      price: dto.price,
      quantity: 1,
      image: dto.imageUrl
    };
  }

  static toDto(vm: ItemViewModel): ProductDto {
    return {
      id: vm.id,
      title: vm.name,
      price: vm.price,
      imageUrl: vm.image,
      stock: vm.quantity // supondo que quantity no VM seja o estoque atual
    };
  }
}
