import { Component, Input, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'lexi',
  templateUrl: './lexi.component.html',
  styleUrls: ['./lexi.component.scss']
})
export class LexiComponent implements OnInit {
  @Input() mood: string;
  @Input() message: string;

  constructor(private userService: UserService) { }

  ngOnInit(): void {

  }
}
