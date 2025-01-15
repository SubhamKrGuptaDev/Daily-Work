import { Injectable } from '@angular/core';
import { Address } from '../interface/address.interface';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiServiceService {
  private apiUrl = 'http://localhost:8080/address';

  constructor(private http: HttpClient) {}

  getAll(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  getById(id: Number): Observable<any> {
    return this.http.get(this.apiUrl, { params: { id: id.toString() } });
  }

  create(address: Address): Observable<any> {
    return this.http.post(this.apiUrl, address);
  }

  update(address: Address): Observable<any> {
    return this.http.put(this.apiUrl, address);
  }

  delete(id: Number): Observable<any> {
    return this.http.delete(this.apiUrl, { params: { id: id.toString() } });
  }
}
