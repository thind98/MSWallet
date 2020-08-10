import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'
import { MatSnackBar } from '@angular/material/snack-bar'
import { UserService } from 'src/app/services/user.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-new-pass',
  templateUrl: './new-pass.component.html',
  styleUrls: ['./new-pass.component.scss']
})
export class NewPassComponent implements OnInit {

  form = new FormGroup({
    nPass : new FormControl('', [
      Validators.required,
      Validators.maxLength(30),
      Validators.minLength(8)
    ]),
  
    rPass : new FormControl('', [
      Validators.required
    ])
  })


  newPass: string;
  rePass: string;
  hide: boolean = true;

  constructor(
    public dialog: MatDialogRef<NewPassComponent>,
    @Inject(MAT_DIALOG_DATA) public user,
    public uService: UserService,
    public snackBar: MatSnackBar
  ) { }

    setNewPass(){
      if(this.newPass == this.rePass){
        this.user.password = this.newPass;
        this.uService.userUpdate(this.user).subscribe(data => {
          this.snackBar.open("Change Password Successfully!","Close",{
            duration: 3000,
            verticalPosition: "bottom",
            horizontalPosition: "center"
          });
          this.onClose();
        })
      }else{
        console.log('lmao')
      }
    }

    onClose(){
      this.dialog.close();
    }

  ngOnInit() {
  }

}
