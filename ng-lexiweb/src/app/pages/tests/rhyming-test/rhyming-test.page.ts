import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../../../services/token-storage.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TestService } from '../../../services/test.service';
import { Test } from '../../../interfaces/test.interface';
import { range } from 'rxjs';
import { faVolumeUp } from '@fortawesome/free-solid-svg-icons';

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
  numberOfQuestions: number
  isCurrentQuestionAnsweredCorrectly = false
  currentIdx = 0;
  showBackToTestsButton = false;
  shouldShowSoundButton = false;
  fileName: string;
  faVolumeUp = faVolumeUp

  constructor(private route: ActivatedRoute,
              private testService: TestService,
              private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.testId = params['id'];
      this.testService.getTestById(this.testId).subscribe(it => {
        this.test = it
        this.numberOfQuestions = this.test.questions.length
        this.setCurrentQuestion(this.currentIdx)
        // let mainWord = this.test.questions[0].mainWord.toUpperCase()
        // this.message = `Одбери кој од понудените зборови се римува со зборот ${mainWord}`
        // range(0, 3).forEach(idx => {
        //   console.log(this.test.questions[0].incorrectWords[idx])
        //   this.availableWords.push(this.test.questions[0].incorrectWords[idx])
        // })
        // this.availableWords.push(this.test.questions[0].matchingWord);
        // this.currentMatchingWord = this.test.questions[0].matchingWord
      })
    })
  }

  setCurrentQuestion(questionIndex: number) {
    let mainWord = this.test.questions[questionIndex].mainWord.toUpperCase()
    this.message = `Одбери кој од понудените зборови се римува со зборот ${mainWord}`
    this.mood = 'BIG_SMILE'
    this.shouldShowSoundButton = true;
    this.fileName = mainWord.toLowerCase();
    // loop through the incorrect words and add them to the list of available words
    range(0, 3).forEach(wordIndex => {
      console.log(this.test.questions[questionIndex].incorrectWords[wordIndex])
      this.availableWords.push(this.test.questions[questionIndex].incorrectWords[wordIndex])
    })
    // add the matching word to the array
    this.availableWords.push(this.test.questions[questionIndex].matchingWord);

    // set the current matching word for validation
    this.currentMatchingWord = this.test.questions[questionIndex].matchingWord

    // shuffle the array of available words so that the answers can be randomized
    this.shuffleArray(this.availableWords)
  }

  checkIfCorrect(word) {
    if (word == this.currentMatchingWord) {
      if (this.currentIdx == this.numberOfQuestions - 1) {
        this.mood = "SATISFIED";
        this.message = "Честитки! Успешно го завши тестот!";
        this.shouldShowSoundButton = false;
        this.availableWords = Array<string>();
        this.isCurrentQuestionAnsweredCorrectly = false;
        this.showBackToTestsButton = true;
        return;
      }
      this.mood = "HEART_EYES";
      this.message = "Браво! Го одбра точниот збор!";
      this.isCurrentQuestionAnsweredCorrectly = true;
      this.shouldShowSoundButton = false;
    } else {
      this.mood = "CRYING";
      this.message = "Тоа не е точниот одговор. Пробај пак!";
      this.shouldShowSoundButton = true;
    }
  }

  nextQuestion() {
    this.availableWords = Array<string>() // empty the array of available words so it can be filled with new words
    this.isCurrentQuestionAnsweredCorrectly = false;
    this.currentIdx++;
    this.setCurrentQuestion(this.currentIdx);
  }

  shuffleArray(array) {
    for (let i = array.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [array[i], array[j]] = [array[j], array[i]];
    }
  }

  openTests() {
    this.router.navigate(['/tests']);
  }

  toggleSound(word: string) {
    let audio = new Audio()
    audio.src = "../../../../assets/audio/" + word.toLowerCase() + ".mp3"
    audio.play()
  }
}
