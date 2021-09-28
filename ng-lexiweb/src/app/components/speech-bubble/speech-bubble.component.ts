import { Component, Input, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'speech-bubble',
  templateUrl: './speech-bubble.component.html',
  styleUrls: ['./speech-bubble.component.scss']
})
export class SpeechBubbleComponent implements OnInit {
  @Input() message: string;

  constructor(private userService: UserService) { }

  ngOnInit(): void {

  }
}
