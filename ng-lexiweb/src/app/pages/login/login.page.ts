import { Component, OnInit, ViewChild } from '@angular/core';
import { TokenStorageService } from '../../services/token-storage.service';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { LexiComponent } from '../../components/lexi/lexi.component';

@Component({
  selector: 'login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss']
})
export class LoginPage implements OnInit {
  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  message: string;
  mood: string;

  @ViewChild('lexi') lexi: LexiComponent

  constructor(private userService: UserService,
              private tokenStorage: TokenStorageService,
              private router: Router) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    } else {
      this.message = "Внеси ги твоите податоци за да се најавиш на сајтот";
      this.mood = "NEUTRAL";
    }
  }

  onSubmit(): void {
    const { username, password } = this.form;

    this.userService.login(username, password).subscribe(
      data => {
        this.tokenStorage.saveToken(data.token);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.mood = "PROUD"
        this.message = `Успешна најава, ${username}! Сега може да ги пристапите вежбите`;
      },
      err => {
        this.errorMessage = err.error.message;
        this.mood = "CROSS_EYED"
        this.message = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  testsLink() {
    this.router.navigate(['/tests']);
  }

  homeLink(): void {
    this.router.navigate(['/']);
  }
}
