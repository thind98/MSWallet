import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User_Wallet_display } from 'src/app/models/user_wallet_display';
import { User_Wallet } from 'src/app/models/user_wallet';

@Injectable({
  providedIn: 'root'
})
export class UserWalletService {

  private UWdisplay_Url: string;

  private UW_url: string;

  constructor(private http:HttpClient) { 
    this.UWdisplay_Url = 'http://localhost:3000/user_wallet_display';

    this.UW_url = 'http://localhost:3000/user_wallet';
  }

  // find all wallet by current user id
  findAll(id:number): Observable<User_Wallet_display[]>{
    return this.http.get<User_Wallet_display[]>(`${this.UWdisplay_Url}/?user_id=${id}`);
  }

  //find all user(member) within a wallet; 'id' is wallet_id
  findAllUser(id:number): Observable<User_Wallet_display[]>{
    return this.http.get<User_Wallet_display[]>(`${this.UWdisplay_Url}/?wallet_id=${id}`);
  }

  // add wallet pt2 (insert into user_wallet)
  addUserWallet(uw: User_Wallet): Observable<User_Wallet>{
    return this.http.post<User_Wallet>(this.UW_url,uw);
  }

  //delete user_wallet
  deleteUserWallet(id:number): Observable<User_Wallet>{
    return this.http.delete<User_Wallet>(`${this.UW_url}/${id}`);
  }

  //get user_wallet by wallet_id
  getUserWallet(id): Observable<User_Wallet[]>{
    return this.http.get<User_Wallet[]>(`${this.UW_url}?wallet_id=${id}`);
  }

  //get user_wallet by user_id and wallet_id
  getUserWalletBy2Id(user_id, wallet_id): Observable<User_Wallet>{
    return this.http.get<User_Wallet>(`${this.UW_url}?user_id=${user_id}&wallet_id=${wallet_id}`);
  }
}
