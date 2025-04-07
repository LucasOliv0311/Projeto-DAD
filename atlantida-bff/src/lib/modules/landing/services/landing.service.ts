import { Injectable } from '@nestjs/common';

@Injectable()
export class LandingService {
    private apiUrl = "";

  getProducts() {
    return 'Hello World!';
  }
}