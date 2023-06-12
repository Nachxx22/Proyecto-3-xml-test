import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BackendService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getMatrix(): Observable<any> {
    return this.http.get(`${this.baseUrl}/matriz`);
  }

  sendInstructions(instructions: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/instructions`, { instructions });
  }
}
