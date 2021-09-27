import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { UserService } from '../../services/user.service';
import { User } from '../../interfaces/user.interface';

@Component({
  selector: 'register',
  templateUrl: './register.page.html',
  styleUrls: ['./register.page.scss']
})
export class RegisterPage implements OnInit {
  form: any = {
    username: null,
    email: null,
    password: null,
    firstName: null,
    lastName: null,
    dateOfBirth: null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log(this.form)
    let timestamp = Date.parse(this.form.dateOfBirth)
    let dateOfBirth = new Date(timestamp)
    console.log(timestamp)
    let request: User
    request = {
      username: this.form.username,
      password: this.form.password,
      firstName: this.form.firstName,
      lastName: this.form.lastName,
      email: this.form.email,
      dateOfBirth: dateOfBirth
    } as User;
    this.userService.register(request).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
