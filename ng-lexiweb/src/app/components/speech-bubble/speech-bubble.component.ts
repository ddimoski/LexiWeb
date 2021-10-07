import { Component, Input, OnInit } from '@angular/core';
import { faVolumeUp } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'speech-bubble',
  templateUrl: './speech-bubble.component.html',
  styleUrls: ['./speech-bubble.component.scss']
})
export class SpeechBubbleComponent implements OnInit {
  @Input() message: string;
  @Input() playSound = false
  @Input() fileName: string
  faVolumeUp = faVolumeUp

  constructor() { }

  ngOnInit(): void {

  }

  toggleSound() {
    let audio = new Audio()
    audio.src = "../../../assets/audio/" + this.fileName + ".mp3" //this.fileLocation
    audio.play()
  }
}
