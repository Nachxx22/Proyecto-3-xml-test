import { Component } from '@angular/core';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'Frontend';
  public treeviewData : Object [] = [
    {id: '01', name: 'Local Disk (C:)'},
    {id: '02', name: 'Local Disk (D:)'},
    {id: '03', name: 'Local Disk (E:)'}
  ];

  public datasourceFields : Object = {
    dataSource : this.treeviewData, id: 'id', text: 'name'
  }

  
}


