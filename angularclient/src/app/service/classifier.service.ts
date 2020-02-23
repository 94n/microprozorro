import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Product} from '../model/product';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class ClassifierService {

  private productUrl: string;
  private productsUrl: string;
  private updateUrl: string;

  constructor(private http: HttpClient) {
    this.productUrl = 'http://localhost:8001/product/';
    this.productsUrl = 'http://localhost:8002/productsublist/';
    this.updateUrl = 'http://localhost:8003/update';
  }

  public find(code: string): Observable<Product[]> {
    return this.http.get<Product[]>(this.productsUrl + code);
  }

  public findOne(code: string): Observable<Product[]> {
    return this.http.get<Product[]>(this.productUrl + code);
  }

  public update(): Observable<Product[]> {
    return this.http.get<Product[]>(this.updateUrl);
  }

}
