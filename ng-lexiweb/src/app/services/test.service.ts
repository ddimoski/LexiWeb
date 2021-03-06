import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Test } from '../interfaces/test.interface';

const API_URL = 'http://localhost:8080/api/test';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class TestService {
  constructor(private http: HttpClient) { }

  getAllTests(): Observable<any> {
    return this.http.get(`${API_URL}/all`);
  }

  getTestById(id: number): Observable<any> {
    return this.http.get(`${API_URL}/${id}`);
  }

}
