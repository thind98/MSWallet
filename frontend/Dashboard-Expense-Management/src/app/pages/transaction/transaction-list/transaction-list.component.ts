import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Transaction_display } from 'src/app/models/transaction_display';
import { TransService } from 'src/app/services/trans.service'
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { TransactionAddComponent } from '../transaction-add/transaction-add.component';
import { TransactionUpdateComponent } from '../transaction-update/transaction-update.component'

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.scss']
})
export class TransactionListComponent implements OnInit {

  transList: Transaction_display[];

  walletName: string;

  constructor(
    private ActivatedRoute: ActivatedRoute,
    public transService: TransService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit() {
    this.getList();
  }

  getList() {
    this.ActivatedRoute.params.subscribe(param => {
      this.transService.getListByWalletId(param.wallet_id).subscribe(data => {
        this.walletName = data[0].wallet_name;
        return this.transList = data;
      })
    })
  }

  newTransDialog() {
    this.ActivatedRoute.params.subscribe(param => {
      console.log('initiating new transaction dialogue');
      const dialogConfig = new MatDialogConfig();
      dialogConfig.disableClose = true;
      dialogConfig.autoFocus = true;
      dialogConfig.width = "40%";
      dialogConfig.data = {
        id: param.wallet_id
      }
      this.dialog.open(TransactionAddComponent, dialogConfig);
    })
  }

  updateTransDialog(t:Transaction_display) {
    console.log('initiating update transaction dialogue');
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "40%";
    dialogConfig.data = t;
    this.dialog.open(TransactionUpdateComponent, dialogConfig);
  }

  deleteTransaction(id) {
    if (confirm("Delete transaction No." + id + "?")) {
      this.transService.deleteById(id).subscribe(delta => {
        console.log('Transaction deleted successfully!')
        this.getList();
      })
    }
  }

}
