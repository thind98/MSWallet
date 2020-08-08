import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Wallet } from 'src/app/models/wallet';
import { User_Wallet } from 'src/app/models/user_wallet';
import { WalletService } from 'src/app/services/wallet.service';
import { UserWalletService } from 'src/app/services/user-wallet.service';

@Component({
  selector: 'app-wallet-add',
  templateUrl: './wallet-add.component.html',
  styleUrls: ['./wallet-add.component.scss']
})
export class WalletAddComponent implements OnInit {

  wallet: Wallet;
  user_wallet: User_Wallet;

  constructor(
    public dialog: MatDialogRef<WalletAddComponent>,
    private snackBar: MatSnackBar,
    public service: WalletService,
    public uwService: UserWalletService,
  ) { }

  ngOnInit() {
    this.wallet = new Wallet;
  }

  onClose(){
    this.dialog.close();
    // this.service.filter('click');
  }

  addWallet(){
    console.log(this.wallet);
    this.wallet.currency = this.wallet.balance;
    this.wallet.create_date = new Date().toDateString();
    this.service.addWallet(this.wallet).subscribe(data => {
      console.log(data)
      console.log(data.id)
      console.log('Add Wallet Successfully!');
      console.log('Adding User_Wallet...');
      this.user_wallet = {
        id: null,
        user_id: 2,
        wallet_id: data.id,
        role: true
      }
      this.uwService.addUserWallet(this.user_wallet).subscribe(dota => {
        console.log('Add User_Wallet Successfully!');
        this.snackBar.open("Add Successfully!","Close",{
          duration: 3000,
          verticalPosition: "bottom",
          horizontalPosition: "center"
        });
      })
    })
    this.onClose();
  }

}
