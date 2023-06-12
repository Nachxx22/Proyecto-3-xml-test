import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  email: string ="";
  username: string ="";
  password: string ="";


  constructor(private http: HttpClient )
  {

  }
  save()
  {

    let bodyData = {
      "email" : this.email,
      "username" : this.username,
      "password" : this.password
    };
    this.http.post("http://localhost:8080/users",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("User Registered Successfully");

    });
  }

}
