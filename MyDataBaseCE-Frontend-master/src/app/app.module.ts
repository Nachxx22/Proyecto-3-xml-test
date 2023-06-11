import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { TreeViewModule } from '@syncfusion/ej2-angular-navigations';
import { ConexionComponent } from './conexion/conexion.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';




@NgModule({
  declarations: [
    AppComponent,
    ConexionComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    TreeViewModule


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
