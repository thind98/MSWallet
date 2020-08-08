import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import { UserWalletService } from 'src/app/services/user-wallet.service';
import { User_Wallet } from 'src/app/models/user_wallet';
import { ActivatedRoute } from '@angular/router';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-wallet-user-add',
  templateUrl: './wallet-user-add.component.html',
  styleUrls: ['./wallet-user-add.component.scss']
})
export class WalletUserAddComponent implements OnInit {

  newMembers: string;

  names: string[];

  newWalletsMember: User_Wallet;

  constructor(
    public Dialog: MatDialogRef<WalletUserAddComponent>,
    private snackBar: MatSnackBar,
    private UserService: UserService,
    private uwService: UserWalletService,
    private ActivatedRoute: ActivatedRoute,
    @Inject(MAT_DIALOG_DATA) public currentWallet
  ) { }

  ngOnInit() {
    this.newMembers = null;
  }

  onClose() {
    this.Dialog.close();
    // this.service.filter('click');
  }

  addUser() {
    this.names = this.newMembers.split(",");
    this.names.forEach(user => {
      console.log(user.trim())
      this.UserService.getUserByUsername(user.trim()).subscribe(data => {
        this.newWalletsMember = {
          id: null,
          user_id: data[0].id,
          wallet_id: this.currentWallet.id,
          role: false
        }
        this.uwService.addUserWallet(this.newWalletsMember).subscribe(adata => {
          console.log('Added 1 new member to wallet!')
        })
        console.log(this.newWalletsMember)
      })
    })
  }

}
