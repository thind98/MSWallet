import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";

import { User_Wallet_display } from 'src/app/models/user_wallet_display';
import { WalletAddComponent } from "../wallet-add/wallet-add.component";
import { WalletUpdateComponent } from "../wallet-update/wallet-update.component";
import { WalletService } from "src/app/services/wallet.service";
import { Wallet } from 'src/app/models/wallet';
// import { UserService } from "src/app/services/user.service";

@Component({
  selector: 'app-wallet-list',
  templateUrl: './wallet-list.component.html',
  styleUrls: ['./wallet-list.component.scss']
})
export class WalletListComponent implements OnInit {

  public wallets: User_Wallet_display[];

  constructor(
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    public service: WalletService,
    // public Uservice: UserService
  ) { }

  ngOnInit() {
    this.getGrid();
    // console.log(this.Uservice.currentUser)
  }

  getGrid(){
    this.service.findAll().subscribe(data => {
      return this.wallets = data;
    })
  }

  addWalletDialog(){
    console.log('initiating add-wallet dialogue');
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "40%";
    this.dialog.open(WalletAddComponent, dialogConfig);
  }

  updateWalletDialog(w: Wallet){
    console.log('initiating update-wallet dialogue');
    this.service.formWallet = w;
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "40%";
    this.dialog.open(WalletUpdateComponent, dialogConfig);
  }

}
