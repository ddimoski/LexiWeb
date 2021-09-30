import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePage } from './pages/home/home.page';
import { ProfilePage } from './pages/profile/profile.page';
import { LoginPage } from './pages/login/login.page';
import { RegisterPage } from './pages/register/register.page';
import { TestListPage } from './pages/tests/test-list/test-list.page';
import { AboutDyslexiaPage } from './pages/about-dyslexia/about-dyslexia.page';
import { RhymingTestPage } from './pages/tests/rhyming-test/rhyming-test.page';


const routes: Routes = [
  { path: 'home', component: HomePage },
  { path: 'login', component: LoginPage },
  { path: 'register', component: RegisterPage },
  { path: 'profile', component: ProfilePage },
  { path: 'test/:id', component: RhymingTestPage },
  { path: 'tests', component: TestListPage },
  { path: 'about-dyslexia', component: AboutDyslexiaPage },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
