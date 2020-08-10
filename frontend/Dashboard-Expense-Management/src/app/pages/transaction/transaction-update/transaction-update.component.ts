import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Transaction } from 'src/app/models/transaction';
import { Category } from 'src/app/models/category';
import { TransService } from 'src/app/services/trans.service';
import { CategoryService } from 'src/app/services/category.service';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormControl, FormGroup, Validators } from '@angular/forms' 

@Component({
  selector: 'app-transaction-update',
  templateUrl: './transaction-update.component.html',
  styleUrls: ['./transaction-update.component.scss']
})
export class TransactionUpdateComponent implements OnInit {

  transaction: Transaction;
  cateList: Category[];
  today = new Date();

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
    public dialog: MatDialogRef<TransactionUpdateComponent>,
    private snackBar: MatSnackBar,
    public transService: TransService,
    public cateService: CategoryService,
    @Inject(MAT_DIALOG_DATA) public trans
  ) { }

  ngOnInit() {
    this.transaction = {
      amount: this.trans.amount,
      category_id: this.trans.category_id,
      date: this.trans.date,
      id: this.trans.id,
      note: this.trans.note,
      trans_name: this.trans.trans_name,
      trans_type: this.trans.trans_type,
      user_id: this.trans.user_id,
      wallet_id: this.trans.wallet_id
    };
    this.getCateList();
  }

  onClose(){
    this.dialog.close();
  }

  getCateList(){
    this.cateService.getAll().subscribe(data => {
      return this.cateList = data;
    })
  }

  updateTransaction(){
    console.log(this.transaction)
    this.transService.updateTrans(this.transaction).subscribe(data => {
      console.log('update transaction successfully');
      this.onClose();
      this.snackBar.open("Update Transaction Successfully!","Close",{
        duration: 3000,
        verticalPosition: "bottom",
        horizontalPosition: "center"
      });
    })
  }

}
