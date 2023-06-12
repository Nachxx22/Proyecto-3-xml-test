import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { MatrizComponent } from './components/matriz/matriz.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  
  {
  path: 'home',
  component: HomeComponent,
  
  },
  {
  
  path: 'register',
  component: RegisterComponent,
  },

  {
    path: 'matriz',
    component: MatrizComponent,

  }
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
