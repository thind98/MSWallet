import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User_Wallet_display } from 'src/app/models/user_wallet_display';
import { Wallet } from 'src/app/models/wallet';
import { User_Wallet } from 'src/app/models/user_wallet';

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  private justWalletUrl: string;

  formWallet: Wallet;

  //user_wallet_display json
  constructor(private http:HttpClient) {
    this.justWalletUrl = 'http://localhost:3000/wallet';
  }

  //get wallet by id
  findById(id:number): Observable<Wallet>{
    return this.http.get<Wallet>(`${this.justWalletUrl}/${id}`);
  }

  // add wallet pt1 (insert into wallet)
  addWallet(w: Wallet): Observable<Wallet>{
    return this.http.post<Wallet>(this.justWalletUrl,w);
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
