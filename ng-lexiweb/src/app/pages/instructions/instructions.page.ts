import { Component, OnDestroy, OnInit } from '@angular/core';
import { faVolumeUp } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';

@Component({
  selector: 'instructions',
  templateUrl: './instructions.page.html',
  styleUrls: ['./instructions.page.scss']
})
export class InstructionsPage implements OnInit, OnDestroy {
  message: string = "Ова се инструкциите за како да се решаваат тестовите";
  mood: string = "SATISFIED";
  faVolumeUp = faVolumeUp
  audio = new Audio();

  constructor(private router: Router) { }

  ngOnInit(): void {

  }

  toggleSound() {
    this.audio.src = "../../../assets/audio/instructions.mp3";
    this.audio.play();
  }

  ngOnDestroy() {
    this.audio.pause();
    this.audio = new Audio();
  }

  openTests() {
    this.router.navigate([`/tests`])
  }
}
