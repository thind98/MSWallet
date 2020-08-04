import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from 'src/app/models/transaction';
import { Transaction_display } from 'src/app/models/transaction_display';
// import { forEach } from '@angular/router/src/utils/collection';
 
@Injectable({
  providedIn: 'root'
})
export class TransService {

  private baseTransUrl: string;

  private listTransUrl: string;

  constructor(private http:HttpClient) {
    this.baseTransUrl = 'http://localhost:3000/transactions';
    this.listTransUrl = 'http://localhost:3000/transaction_display';
  }

  //get all transactions by id(wallet_id) - BASE TRANSACTION IN DATABASE
  findAllByWallet(id:number): Observable<Transaction[]>{
    console.log('finding qualified records...')
    return this.http.get<Transaction[]>(`${this.baseTransUrl}?wallet_id=${id}`);
  }

  //get all transaction_display by wallet_id - TRANSACTION DTO
  getListByWalletId(id:number): Observable<Transaction_display[]>{
    return this.http.get<Transaction_display[]>(`${this.listTransUrl}?wallet_id=${id}`);
  }

  //add transaction
  addTrans(t:Transaction): Observable<Transaction>{
    return this.http.post<Transaction>(this.baseTransUrl,t);
  }

  //update transaction
  updateTrans(t:Transaction): Observable<Transaction>{
    return this.http.put<Transaction>(`${this.baseTransUrl}/${t.id}`,t)
  }

  //delete a transaction by id
  deleteById(id:number): Observable<Transaction>{
    return this.http.delete<Transaction>(`${this.baseTransUrl}/${id}`);
  }





  //test get all transaction
  getAllTrans(): Observable<Transaction[]>{
    return this.http.get<Transaction[]>(this.baseTransUrl);
  }

  //test get all transaction display
  getAllDisTrans(): Observable<Transaction_display[]>{
    return this.http.get<Transaction_display[]>(this.listTransUrl);
  }
}
