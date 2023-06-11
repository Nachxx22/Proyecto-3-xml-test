import { Component } from '@angular/core';
import {HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-conexion',
  templateUrl: './conexion.component.html',
  styleUrls: ['./conexion.component.css']
})
export class ConexionComponent {
  conexion='';
  constructor(private http: HttpClient){}

  ngOnInit(){
    this.http.get("http://localhost:8080/prueba",{responseType: 'text'}).subscribe((resp: any)=>
    {
    this.conexion = resp;
  }
    )
  }
}
