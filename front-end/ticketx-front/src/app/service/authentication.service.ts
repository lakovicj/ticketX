import { Injectable } from '@angular/core';
import { Credentials } from '../dto/credentials';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private _http: HttpClient) { }

  public login(credentials: Credentials): Observable<any> {
    return this._http.post<any>("http://localhost:8080/login", credentials);
  }
}
