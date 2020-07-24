import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User_Wallet_display } from 'src/app/models/user_wallet_display';
import { Wallet } from 'src/app/models/wallet';

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  private walletUrl: string;

  private justWalletUrl: string;

  formWallet: Wallet;

  //user_wallet_display json
  constructor(private http:HttpClient) {
    this.walletUrl = 'http://localhost:3000/user_wallet_display';

    this.justWalletUrl = 'http://localhost:3000/wallet';
  }

  // find all wallet by current user id
  findAll(): Observable<User_Wallet_display[]>{
    return this.http.get<User_Wallet_display[]>(`${this.walletUrl}/?user_id=2`);
  }

  //find all user(member) within a wallet; 'id' is wallet_id
  findAllUser(id:number): Observable<User_Wallet_display[]>{
    return this.http.get<User_Wallet_display[]>(`${this.walletUrl}/?wallet_id=${id}`);
  }

  // // add wallet (need to insert into user_wallet too)
  // addWallet(w: Wallet): Observable<Wallet>{
  //   return this.http.post<Wallet>(this.walletUrl,w);
  // }

  //update wallet
  updateWallet(id: number, w: Wallet): Observable<Wallet>{
    return this.http.put<Wallet>(`${this.walletUrl}/${id}`,w);
  }

  // //delete wallet
  // deleteWallet(id): Observable<Wallet>{
  //   return this.http.delete<Wallet>(`${this.walletUrl}/${id}`);
  // }

}
