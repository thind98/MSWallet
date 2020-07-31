import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User_Wallet_display } from 'src/app/models/user_wallet_display';
import { Wallet } from 'src/app/models/wallet';
import { User_Wallet } from 'src/app/models/user_wallet';

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  private walletUrl: string;

  private justWalletUrl: string;

  private user_wallet_url: string;

  formWallet: Wallet;

  //user_wallet_display json
  constructor(private http:HttpClient) {
    this.walletUrl = 'http://localhost:3000/user_wallet_display';

    this.justWalletUrl = 'http://localhost:3000/wallet';
    
    this.user_wallet_url = 'http://localhost:3000/user_wallet';
  }

  // find all wallet by current user id
  findAll(): Observable<User_Wallet_display[]>{
    return this.http.get<User_Wallet_display[]>(`${this.walletUrl}/?user_id=2`);
  }

  //find all user(member) within a wallet; 'id' is wallet_id
  findAllUser(id:number): Observable<User_Wallet_display[]>{
    return this.http.get<User_Wallet_display[]>(`${this.walletUrl}/?wallet_id=${id}`);
  }

  // add wallet pt1 (insert into wallet)
  addWallet(w: Wallet): Observable<Wallet>{
    return this.http.post<Wallet>(this.justWalletUrl,w);
  }
  // add wallet pt2 (insert into user_wallet)
  addUserWallet(uw: User_Wallet): Observable<User_Wallet>{
    return this.http.post<User_Wallet>(this.user_wallet_url,uw);
  }

  //delete user_wallet
  deleteUserWallet(id:number): Observable<User_Wallet>{
    return this.http.delete<User_Wallet>(`${this.user_wallet_url}/${id}`);
  }

  //get user_wallet by wallet_id
  getUserWallet(id): Observable<User_Wallet[]>{
    return this.http.get<User_Wallet[]>(`${this.user_wallet_url}?wallet_id=${id}`);
  }

  //get user_wallet by user_id and wallet_id
  getUserWalletBy2Id(user_id, wallet_id): Observable<User_Wallet>{
    return this.http.get<User_Wallet>(`${this.user_wallet_url}?user_id=${user_id}&wallet_id=${wallet_id}`);
  }

  //update wallet
  updateWallet(id:number, w: Wallet): Observable<Wallet>{
    console.log('updating wallet...')
    return this.http.put<Wallet>(`${this.justWalletUrl}/${id}`,w);
  }

  //delete wallet
  deleteWallet(id): Observable<Wallet>{
    return this.http.delete<Wallet>(`${this.justWalletUrl}/${id}`);
  }

}
