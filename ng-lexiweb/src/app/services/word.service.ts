import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/words';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class WordService {
  constructor(private http: HttpClient) { }

  getTenRandomWords(): Observable<any> {
    return this.http.get(`${API_URL}/random-10`);
  }
}