import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product';
import { ClassifierService } from '../service/classifier.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {

  products: Product[];

}
