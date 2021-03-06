import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';

import { UserLogin } from '../model/UserLogin';
import { User } from './../model/User';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor (
    private http: HttpClient
  ) { }

  login(userLogin: UserLogin): Observable<UserLogin> {
    return this.http.post<UserLogin>('http://localhost:8080/usuarios/login', userLogin)
  }

  cadastrar(user: User): Observable<User> {
    return this.http.post<User>('http://localhost:8080/usuarios/cadastro', user)
  }

  getByIdUser(id: number): Observable<User>{
    return this.http.get<User>(`http://localhost:8080/usuarios/${id}`)
  }

  logado (){
    let ok: boolean = false

    if(localStorage.getItem('token') != null) {
      ok = true
    }
    return ok
  }
}
