import { Component, OnInit, Inject } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-change-pass',
  templateUrl: './change-pass.component.html',
  styleUrls: ['./change-pass.component.scss']
})
export class ChangePassComponent implements OnInit {

  oPass = new FormControl('', [
    Validators.required,
    Validators.maxLength(30),
    Validators.minLength(8)
  ]);

  nPass = new FormControl('', [
    Validators.required,
    Validators.maxLength(30),
    Validators.minLength(8)
  ]);

  rPass = new FormControl('', [
    Validators.required,
    Validators.maxLength(30),
    Validators.minLength(8)
  ]);

  changedUser: User;
  oldPass: string;
  newPass: string;
  rePass: string;
  wrong: boolean = false;
  hide: boolean = true;

  constructor(
    public dialog: MatDialogRef<ChangePassComponent>,
    private snackBar: MatSnackBar,
    private uService: UserService,
    @Inject(MAT_DIALOG_DATA) public user
  ) { }

  onClose(){
    this.dialog.close();
  }

  changePass(){
    if(this.oldPass != this.user.password){
      this.wrong = true;
    }else if(this.newPass != this.rePass){
      alert('nhap lai mk')
    }else{
      this.user.password = this.newPass;
      this.uService.userUpdate(this.user).subscribe(data => {
        this.wrong = false;
        this.onClose();
        this.snackBar.open("Change Password Successfully!","Close",{
          duration: 3000,
          verticalPosition: "bottom",
          horizontalPosition: "center"
        });
      })
    }
  }

  ngOnInit() {
  }

}
