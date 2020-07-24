import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Wallet } from 'src/app/models/wallet';

@Component({
  selector: 'app-wallet-add',
  templateUrl: './wallet-add.component.html',
  styleUrls: ['./wallet-add.component.scss']
})
export class WalletAddComponent implements OnInit {

  wallet: Wallet;

  constructor(
    public dialog: MatDialogRef<WalletAddComponent>,
    private snackbar: MatSnackBar
  ) { }

  ngOnInit() {
    this.wallet = new Wallet;
  }

  onClose(){
    this.dialog.close();
    // this.service.filter('click');
  }

}
