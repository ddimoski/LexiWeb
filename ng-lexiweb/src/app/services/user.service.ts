import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../interfaces/user.interface';

const API_URL = 'http://localhost:8080/api/user';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post(`${API_URL}/login`, {
      username,
      password
    }, httpOptions);
  }

  register(registerRequest: User): Observable<any> {
    return this.http.post(`${API_URL}/register`, registerRequest, httpOptions);
  }


  getPublicContent(): Observable<any> {
    return this.http.get(`${API_URL}/all`, { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

}
