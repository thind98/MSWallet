import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router'
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { MatSnackBar } from '@angular/material/snack-bar';
import { ForgetPassComponent } from 'src/app/pages/login/forget-pass/forget-pass.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  constructor(
    private uService: UserService,
    private router: Router,
    private dialog: MatDialog,
    private snackBar: MatSnackBar) { }

  user: User;
  username: string;
  pass: string;
  repass: string;
  hide: boolean = true;

  wrong: boolean = false;
  existed: boolean = false;

  signup() {
    this.uService.getUserByUsername(this.user.user_name).subscribe(data => {
      if(data[0] == null){
        this.existed = false;
        if (this.repass != this.user.password) {
          alert('nhap lai mk cho dung')
        } else {
          this.uService.register(this.user).subscribe(dta => {
            console.log('sign up successfully!')
            this.snackBar.open("Register Successfully!","Close",{
              duration: 3000,
              verticalPosition: "bottom",
              horizontalPosition: "center"
            });
          })
        }
      }else{
        this.existed = true;
      }
    })

    
  }

  login() {
    console.log(this.username, this.pass)
    this.uService.checkLogin(this.username, this.pass).subscribe(data => {
      if (data[0] != null) {
        console.log(data[0])
        sessionStorage.setItem('username', this.username);
        sessionStorage.setItem('id', data[0].id);
        sessionStorage.setItem('name', data[0].name);
        this.router.navigate(['/dashboard']);
        this.wrong = false;
      } else {
        console.log('yike')
        this.wrong = true;
      }
    })
  }

  forgetPassDialog() {
    console.log('initiating forget password dialog');
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = "30%";
    this.dialog.open(ForgetPassComponent, dialogConfig);
  }

  ngOnInit() {
    this.user = new User;
    this.uService.isLoggedIn()
  }

}
