import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { ChangePassComponent } from 'src/app/pages/user/change-pass/change-pass.component';
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
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  upName = new FormControl('', [
    Validators.required,
    Validators.maxLength(100),
    Validators.pattern('^[a-z ]+$/i')
  ]);

  upPhone = new FormControl('', [
    Validators.required,
    Validators.pattern('^[0-9]{10}$')
  ]);

  currentUser: User;

  constructor(public uService: UserService, 
    private snackBar: MatSnackBar,
    private dialog: MatDialog) { }

  getUser(){
    this.uService.getUser(+sessionStorage.getItem('id')).subscribe(data => {
      this.currentUser = data;
    })
  }

  userUpdate(){
    this.uService.userUpdate(this.currentUser).subscribe(data => {
      sessionStorage.setItem('name',data.name);
      this.snackBar.open("Update Successfully!","Close",{
        duration: 3000,
        verticalPosition: "bottom",
        horizontalPosition: "center"
      });
    })
  }

  changePass(){
    console.log('initiating change password dialogue');
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = "40%";
    dialogConfig.data = this.currentUser;
    this.dialog.open(ChangePassComponent, dialogConfig);
  }

  ngOnInit() {
    this.getUser()
  }

}
