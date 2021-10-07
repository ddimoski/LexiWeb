import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomePage } from './pages/home/home.page';
import { LoginPage } from './pages/login/login.page';
import { RegisterPage } from './pages/register/register.page';
import { ProfilePage } from './pages/profile/profile.page';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './app-material.module';
import { authInterceptorProviders } from './helpers/auth.interceptor';
import { TestListPage } from './pages/tests/test-list/test-list.page';
import { RhymingTestPage } from './pages/tests/rhyming-test/rhyming-test.page';
import { FillInTheBlanksTestPage } from './pages/tests/fill-in-the-blanks-test/fill-in-the-blanks-test.page';
import { LexiComponent } from './components/lexi/lexi.component';
import { SpeechBubbleComponent } from './components/speech-bubble/speech-bubble.component';
import { AboutDyslexiaPage } from './pages/about-dyslexia/about-dyslexia.page';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { InstructionsPage } from './pages/instructions/instructions.page';

const pages = [
  AppComponent,
  HomePage,
  LoginPage,
  RegisterPage,
  ProfilePage,
  TestListPage,
  RhymingTestPage,
  FillInTheBlanksTestPage,
  LexiComponent,
  SpeechBubbleComponent,
  AboutDyslexiaPage,
  InstructionsPage
];

const modules = [
  BrowserModule,
  AppRoutingModule,
  FormsModule,
  HttpClientModule,
  FormsModule,
  MaterialModule,
  BrowserAnimationsModule,
  FontAwesomeModule
];

@NgModule({
  declarations: [...pages],
  imports: [...modules, FontAwesomeModule],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule {}
