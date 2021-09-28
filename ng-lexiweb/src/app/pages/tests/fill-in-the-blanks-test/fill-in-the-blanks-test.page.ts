import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../../../services/token-storage.service';

@Component({
  selector: 'fill-in-the-blanks-test',
  templateUrl: './fill-in-the-blanks-test.page.html',
  styleUrls: ['./fill-in-the-blanks-test.page.scss']
})
export class FillInTheBlanksTestPage implements OnInit {
  currentUser: any;

  constructor(private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
  }
}
