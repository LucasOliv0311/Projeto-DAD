import { ComponentFixture, TestBed } from '@angular/core/testing';
import { StoreProductOptionsComponent} from './product-options.component';

describe('ProductOptionsComponent', () => {
  let component: StoreProductOptionsComponent;
  let fixture: ComponentFixture<StoreProductOptionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [StoreProductOptionsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StoreProductOptionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
