import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'about-dyslexia',
  templateUrl: './about-dyslexia.page.html',
  styleUrls: ['./about-dyslexia.page.scss']
})
export class AboutDyslexiaPage implements OnInit {
  message: string = "Овде можеш да дознаеш повеќе за дислексијата";
  mood: string = "NEUTRAL";

  constructor() { }

  ngOnInit(): void {

  }

}
