import { Component } from '@angular/core';
import {ClassifierService} from "./service/classifier.service";
import {ProductListComponent} from "./product-list/product-list.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title: string;

  constructor(private classifierService: ClassifierService) {
    this.title = 'Classifier service';
  }

  find(code: string) {
    this.classifierService.find(code).subscribe(data => {
      ProductListComponent.prototype.products = data;
    });
  }

  findOne(code: string) {
    this.classifierService.findOne(code).subscribe(data => {
      ProductListComponent.prototype.products = data;
    });
  }

  update() {
    this.classifierService.update().subscribe(data => {
      ProductListComponent.prototype.products = data;
    });
  }

}
