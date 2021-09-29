import { Question } from './question.interface';

export interface Test {
  id?: number;
  name: string;
  questions: Question[]
}
