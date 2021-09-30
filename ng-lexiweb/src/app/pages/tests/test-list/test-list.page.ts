import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../../../services/token-storage.service';
import { TestService } from '../../../services/test.service';
import { Test } from '../../../interfaces/test.interface';
import { Router } from '@angular/router';

@Component({
  selector: 'test-list',
  templateUrl: './test-list.page.html',
  styleUrls: ['./test-list.page.scss']
})
export class TestListPage implements OnInit {
  message: string = "";
  mood: string = "NEUTRAL";
  allTests: Test[]

  constructor(private testService: TestService,
              private router: Router) { }

  ngOnInit(): void {
    this.testService.getAllTests().subscribe(tests => {
        this.allTests = tests
        console.log(this.allTests)
      },
        error => console.log(error.error.message))

    this.testService.getTestById(1).subscribe(test => {
        console.log(test)
      },
      error => console.log(error.error.message))
  }

  openTest(id: number) {
    this.router.navigate([`/test/${id}`])
  }
}
