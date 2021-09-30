import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../../../services/token-storage.service';
import { ActivatedRoute } from '@angular/router';
import { TestService } from '../../../services/test.service';
import { Test } from '../../../interfaces/test.interface';
import { range } from 'rxjs';

@Component({
  selector: 'rhyming-test',
  templateUrl: './rhyming-test.page.html',
  styleUrls: ['./rhyming-test.page.scss']
})
export class RhymingTestPage implements OnInit {
  testId: number
  mood: string = 'BIG_SMILE'
  test: Test
  message: string
  availableWords: string[] = Array<string>()
  currentMatchingWord: string

  constructor(private route: ActivatedRoute,
              private testService: TestService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.testId = params['id'];
      this.testService.getTestById(this.testId).subscribe(it => {
        this.test = it
        let mainWord = this.test.questions[0].mainWord.toUpperCase()
        this.message = `Одбери кој од понудените зборови се римува со зборот ${mainWord}`
        range(0, 3).forEach(idx => {
          console.log(this.test.questions[0].incorrectWords[idx])
          this.availableWords.push(this.test.questions[0].incorrectWords[idx])
        })
        this.availableWords.push(this.test.questions[0].matchingWord);
        this.currentMatchingWord = this.test.questions[0].matchingWord
      })
    })
  }

  checkIfCorrect(word) {
    if (word == this.currentMatchingWord) {
      this.mood = "HEART_EYES";
      this.message = "Браво! Го одбра точниот збор!"
      // СМЕНИ НА СЛЕДНО ПРАШАЊЕ ОВДЕ
    } else {
      this.mood = "CRYING";
      this.message = "Тоа не е точниот одговор. Пробај пак!"
    }
  }
}
