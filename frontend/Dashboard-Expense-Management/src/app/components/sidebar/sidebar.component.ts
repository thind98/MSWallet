import { Component, OnInit } from '@angular/core';
import { User_Wallet_display } from 'src/app/models/user_wallet_display';
import { WalletService } from 'src/app/services/wallet.service'

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  walletList: User_Wallet_display[];

  constructor(
    public WalletService: WalletService
  ) { }

  ngOnInit() {
    this.getWalletList();
  }

  getWalletList(){
    this.WalletService.findAll().subscribe(data => {
      return this.walletList = data;
    })
  }

}
