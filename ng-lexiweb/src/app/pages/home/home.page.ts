import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../../services/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss']
})
export class HomePage implements OnInit {
  message: string;
  isLoggedIn: boolean
  mood: string = "BIG_SMILE";

  constructor(private tokenStorageService: TokenStorageService,
              private router: Router) { }

  ngOnInit(): void {
    console.log(this.mood)
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if(this.isLoggedIn){
      this.mood = "SATISFIED";
      this.message = "Здраво, дали сакаш да почнеш со вежбање?";
    } else {
      this.message = "Здраво, јас сум жабата Лекси. Добредојде на сајтот! Најави се или регистрирај се за да можеш да"
                     + " ги пристапиш вежбите.";
    }
    console.log(this.mood)
  }

  loginLink() {
    this.router.navigate(['/login']);
  }

  registerLink() {
    this.router.navigate(['/register']);
  }

  testsLink() {
    this.router.navigate(['/tests']);
  }

  dyslexiaLink() {
    this.router.navigate(['/about-dyslexia']);
  }
}
