import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersAPI: string;

  isLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }


  constructor(private http: HttpClient) {
    this.usersAPI = 'http://localhost:3000/users';
  }

  //get user by id. Classic.
  getUser(id: number): Observable<User> {
    return this.http.get<User>(`${this.usersAPI}/${id}`);
  }

  //get user by username
  getUserByUsername(username: string): Observable<User> {
    return this.http.get<User>(`${this.usersAPI}?user_name=${username}`);
  }

  //get user by username, name, phone, sex
  getUserByMany(username: string, name: string, tel: number, sex: boolean): Observable<User> {
    return this.http.get<User>(`${this.usersAPI}?user_name=${username}&name=${name}&phone_number=${tel}&sex=${sex}`)
  }

  //checkLogin (get by user and pass)
  checkLogin(user: string, pass: string): Observable<User> {
    return this.http.get<User>(`${this.usersAPI}?user_name=${user}&password=${pass}`);
  }

  //new registration (insert)
  register(user: User): Observable<User> {
    return this.http.post<User>(this.usersAPI, user);
  }

  //update user info
  userUpdate(user: User): Observable<User> {
    return this.http.put<User>(`${this.usersAPI}/${user.id}`, user);
  }

}
