import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../../../services/token-storage.service';

@Component({
  selector: 'rhyming-test',
  templateUrl: './rhyming-test.page.html',
  styleUrls: ['./rhyming-test.page.scss']
})
export class RhymingTestPage implements OnInit {
  currentUser: any;

  constructor(private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
  }
}
