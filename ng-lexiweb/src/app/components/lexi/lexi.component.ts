import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'lexi',
  templateUrl: './lexi.component.html',
  styleUrls: ['./lexi.component.scss']
})
export class LexiComponent implements OnInit {
  @Input() mood: string;
  @Input() message: string;
  @Input() playSound = false;
  @Input() fileName: string;

  constructor() { }

  ngOnInit(): void {

  }
}
