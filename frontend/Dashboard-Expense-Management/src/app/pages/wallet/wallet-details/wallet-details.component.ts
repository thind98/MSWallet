import { Component, OnInit } from '@angular/core';
import { User_Wallet_display } from 'src/app/models/user_wallet_display';
import { WalletService } from 'src/app/services/wallet.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-wallet-details',
  templateUrl: './wallet-details.component.html',
  styleUrls: ['./wallet-details.component.scss']
})
export class WalletDetailsComponent implements OnInit {

  users: User_Wallet_display[];

  constructor(public service: WalletService,
    private ActivatedRoute : ActivatedRoute ) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers(){
    this.ActivatedRoute.params.subscribe(param => {
      this.service.findAllUser(param.wallet_id).subscribe(data =>{
        return this.users = data;
      })
    })
  }

}
