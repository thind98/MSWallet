import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Transaction } from 'src/app/models/transaction';
import { Category } from 'src/app/models/category';
import { TransService } from 'src/app/services/trans.service';
import { CategoryService } from 'src/app/services/category.service';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormGroup, FormControl, Validators } from '@angular/forms'


@Component({
  selector: 'app-transaction-add',
  templateUrl: './transaction-add.component.html',
  styleUrls: ['./transaction-add.component.scss']
})
export class TransactionAddComponent implements OnInit {

  transaction: Transaction;
  cateList: Category[];
  today: Date;

  form = new FormGroup({
    name: new FormControl('',[
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(30)
    ]),
    cate: new FormControl('',[
      Validators.required
    ]),
    amount: new FormControl('',[
      Validators.required,
      Validators.min(1000)
    ]),
    date: new FormControl('',[
      Validators.required
    ]),
    type: new FormControl('',[
      Validators.required
    ]),
    note: new FormControl('')
  })

  constructor(
    public dialog: MatDialogRef<TransactionAddComponent>,
    private snackBar: MatSnackBar,
    public transService: TransService,
    public cateService: CategoryService,
    @Inject(MAT_DIALOG_DATA) public wallet
  ) { }

  ngOnInit() {
    this.transaction = new Transaction;
    this.getCateList();
    this.today = new Date();
  }

  onClose(){
    this.dialog.close();
    // this.service.filter('click');
  }

  getCateList(){
    this.cateService.getAll().subscribe(data => {
      return this.cateList = data;
    })
  }

  addTransaction(){
    this.transaction.wallet_id = this.wallet.id;
    this.transaction.user_id = 2;
    console.log(this.transaction);
    this.transService.addTrans(this.transaction).subscribe(data => {
      console.log('add transaction successfully');
      this.onClose();
      this.snackBar.open("Add Transaction Successfully!","Close",{
        duration: 3000,
        verticalPosition: "bottom",
        horizontalPosition: "center"
      });
    })
  }

}
