import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Wallet } from 'src/app/models/wallet';
import { WalletService } from 'src/app/services/wallet.service';

@Component({
  selector: 'app-wallet-update',
  templateUrl: './wallet-update.component.html',
  styleUrls: ['./wallet-update.component.scss']
})
export class WalletUpdateComponent implements OnInit {

  wallet: Wallet;

  constructor(
    public dialog: MatDialogRef<WalletUpdateComponent>,
    private snackbar: MatSnackBar,
    public service: WalletService
  ) { }

  ngOnInit() {
    this.wallet = this.service.formWallet;
  }

  onClose(){
    this.dialog.close();
    // this.service.filter('click');
  }

}
