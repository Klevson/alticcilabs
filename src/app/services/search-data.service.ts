import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchDataService {
  private url = "http://localhost:8080/api/alticci/";
  constructor(private http: HttpClient) { }

  getItemByIndex(index: Number) : Observable<Number>{
    return this.http.get<Number>(this.url+index);
  }
}
