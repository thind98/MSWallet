import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router'
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { ForgetPassComponent } from 'src/app/pages/login/forget-pass/forget-pass.component';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  loginForm = new FormGroup({
    loginUser: new FormControl('', [
      Validators.required,
      Validators.maxLength(30),
      Validators.minLength(8),
      Validators.pattern('^[A-Za-z0-9!@#$%^&*]+$')
    ]),
    loginPass: new FormControl('', [
      Validators.required,
      Validators.maxLength(30),
      Validators.minLength(8)
    ])
  })

  regForm = new FormGroup({
    regUser : new FormControl('', [
      Validators.required,
      Validators.maxLength(30),
      Validators.minLength(8)
    ]),

    regName : new FormControl('', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(100),
      Validators.pattern('^[A-Za-z ]+$')
    ]),

    regPhone : new FormControl('', [
      Validators.required,
      Validators.pattern('^0[0-9]{9}$')
    ]),

    regSex : new FormControl('', [
      Validators.required,
    ]),

    regPass : new FormControl('', [
      Validators.required,
      Validators.maxLength(30),
      Validators.minLength(8),
      Validators.pattern('^[A-Za-z!@#$%^&*]+$')
    ]),

    regRepass : new FormControl('', [
      Validators.required
    ])
  })

  constructor(private uService: UserService,
    private router: Router,
    private dialog: MatDialog) { }

  user: User;
  username: string;
  pass: string;
  repass: string;
  hide: boolean = true;

  wrong: boolean = false;

  signup() {
    if (this.repass != this.user.password) {
      alert('nhap lai mk cho dung')
    } else {
      this.uService.register(this.user).subscribe(dta => {
        console.log('sign up successfully!')
      })
    }
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
