import { Component, OnDestroy, OnInit } from '@angular/core';
import { faVolumeUp } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'about-dyslexia',
  templateUrl: './about-dyslexia.page.html',
  styleUrls: ['./about-dyslexia.page.scss']
})
export class AboutDyslexiaPage implements OnInit, OnDestroy {
  message: string = "Овде можеш да дознаеш повеќе за дислексијата";
  mood: string = "NEUTRAL";
  faVolumeUp = faVolumeUp
  audio = new Audio();

  constructor() { }

  ngOnInit(): void {

  }

  toggleSound() {
    this.audio.src = "../../../assets/audio/about.mp3";
    this.audio.play();
  }

  ngOnDestroy() {
    this.audio.pause();
    this.audio = new Audio();
  }
}
