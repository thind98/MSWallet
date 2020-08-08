import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router'
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { ForgetPassComponent } from 'src/app/pages/login/forget-pass/forget-pass.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private uService: UserService,
    private router: Router,
    private dialog: MatDialog) { }

  user: User;
  username: string;
  pass: string;
  repass: string

  signup() {
    if (this.repass != this.user.password) {
      alert('nhap lai mk cho dung')
    } else {
      this.uService.register(this.user).subscribe(dta => {
        console.log('sign up successfully!')
      })
    }
  }

  login(){
    console.log(this.username,this.pass)
    this.uService.checkLogin(this.username, this.pass).subscribe(data => {
      if(data[0] != null){
        console.log(data[0])
        sessionStorage.setItem('username',this.username);
        sessionStorage.setItem('id', data[0].id);
        sessionStorage.setItem('name',data[0].name);
        this.router.navigate(['/dashboard']);
      }else{
        console.log('yike')
      }
    })
  }

  forgetPassDialog(){
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
