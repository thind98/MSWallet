import { Component, OnInit } from '@angular/core';
import { User_Wallet_display } from 'src/app/models/user_wallet_display';
import { User_Wallet } from 'src/app/models/user_wallet'
import { UserWalletService } from 'src/app/services/user-wallet.service';
import { ActivatedRoute } from '@angular/router';
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { WalletUserAddComponent } from './wallet-user-add/wallet-user-add.component'

@Component({
  selector: 'app-wallet-details',
  templateUrl: './wallet-details.component.html',
  styleUrls: ['./wallet-details.component.scss']
})
export class WalletDetailsComponent implements OnInit {

  users: User_Wallet_display[];

  user_wallet: User_Wallet;

  constructor(
    public uwService: UserWalletService,
    private ActivatedRoute: ActivatedRoute,
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
  ) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    this.ActivatedRoute.params.subscribe(param => {
      this.uwService.findAllUser(param.wallet_id).subscribe(data => {
        return this.users = data;
      })
    })
  }

  addUserDialog() {
    this.ActivatedRoute.params.subscribe(param => {
      console.log('initiating add-user dialogue');
      const dialogConfig = new MatDialogConfig();
      dialogConfig.disableClose = true;
      dialogConfig.autoFocus = true;
      dialogConfig.width = "25%";
      dialogConfig.data = {
        id: param.wallet_id
      }
      this.dialog.open(WalletUserAddComponent, dialogConfig);
    })
  }

  deleteUser(user_id) {
    if (confirm("Delete User No." + user_id + " from this wallet?")) {
      // get user_wallet with current wallet_id and chosen user_id
      console.log('Initiating delete process...');
      this.ActivatedRoute.params.subscribe(param => {
        this.uwService.getUserWalletBy2Id(user_id, param.wallet_id).subscribe(data => {
          console.log(data);
          this.user_wallet = data;
          console.log('Deleting record...');
          //Delete user_wallet 
          this.uwService.deleteUserWallet(this.user_wallet[0].id).subscribe(delta => {
            console.log('Deleted user from wallet!')
          })
        })
      })
    }
  }

  delTest() {
    this.uwService.deleteUserWallet(1).subscribe(data => {
      console.log('lol')
    })
  }

}
