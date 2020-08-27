import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';
import { Credentials } from '../dto/credentials';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials = new Credentials();

  constructor(private _authService: AuthenticationService) { }

  ngOnInit() {
  }

  loginUser() {
    this._authService.login(this.credentials).subscribe(
      data => console.log(data),
      error => console.log("SOmething went wrong!")
    )
  }

}
