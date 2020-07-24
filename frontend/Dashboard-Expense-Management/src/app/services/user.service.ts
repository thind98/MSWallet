import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersAPI: string;

  currentUser: User;

  constructor(private http:HttpClient) { 
    this.usersAPI = 'http://localhost:3000/users';
  }

  //get user by id. Classic.
  getUser(id:number) : Observable<User>{
    return this.http.get<User>(`${this.usersAPI}/${id}`);
  }

}
