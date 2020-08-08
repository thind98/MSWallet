import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";

import { User_Wallet_display } from 'src/app/models/user_wallet_display';
import { WalletAddComponent } from "../wallet-add/wallet-add.component";
import { WalletUpdateComponent } from "../wallet-update/wallet-update.component";
import { WalletService } from "src/app/services/wallet.service";
import { UserWalletService } from 'src/app/services/user-wallet.service';
import { TransService } from 'src/app/services/trans.service';
import { Wallet } from 'src/app/models/wallet';
// import { UserService } from "src/app/services/user.service";

@Component({
  selector: 'app-wallet-list',
  templateUrl: './wallet-list.component.html',
  styleUrls: ['./wallet-list.component.scss']
})
export class WalletListComponent implements OnInit {

  public wallets: User_Wallet_display[];
  walletName: string;

  constructor(
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    public service: WalletService,
    public transService: TransService,
    public uwService: UserWalletService
  ) { }

  ngOnInit() {
    this.getGrid();
  }

  searchWallet() {
    let a = this.walletName.trim();
    console.log(a)
    if (a == "" || a == undefined) {
      this.getGrid();
    } else {
      this.wallets = this.wallets.filter(w => {
        w.wallet_name == a;
      })
      console.log(this.wallets)
    }
  }

  getGrid() {
    this.uwService.findAll(+sessionStorage.getItem('id')).subscribe(data => {
      console.log(data)
      return this.wallets = data;
    })
  }

  addWalletDialog() {
    console.log('initiating add-wallet dialogue');
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "40%";
    this.dialog.open(WalletAddComponent, dialogConfig);
  }

  updateWalletDialog(w: Wallet) {
    console.log('initiating update-wallet dialogue');
    this.service.formWallet = w;
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "40%";
    this.dialog.open(WalletUpdateComponent, dialogConfig);
  }

  deleteWallet(wallet_id) { //will update with backend process later
    if (confirm("Delete Wallet No." + wallet_id + "?")) {
      console.log('initiating delete process...')
      console.log('deleting all transactions...')
      //find all transactions winthin the wallet
      this.transService.findAllByWallet(wallet_id).subscribe(data => {
        //delete each transaction one by one using loop
        data.forEach(element => {
          console.log(element);
          this.transService.deleteById(element.id).subscribe(delta => {
            console.log('deleted one transaction!');
          })
        });
      })
      console.log('deleting all users in wallet...')
      //find all users winthin the wallet (user_wallet)
      this.uwService.getUserWallet(wallet_id).subscribe(data => {
        //delete each user from wallet one by one
        data.forEach(element => {
          console.log(element);
          this.uwService.deleteUserWallet(element.id).subscribe(delta => {
            console.log('deleted one user!')
          })
        })
      })
      console.log('deleting wallet (finally)')
      this.service.deleteWallet(wallet_id).subscribe(data => {
        console.log('delete wallet successfully!')
      })
    }
  }

}
