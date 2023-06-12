import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface MatrixData {
  matrix: string[][];
  name: string;
}

@Component({
  selector: 'app-matriz',
  templateUrl: './matriz.component.html',
  styleUrls: ['./matriz.component.css']
})
export class MatrizComponent implements OnInit {
  matrices: MatrixData[] = [];
  instructionText: string = '';
  responseMatrix: MatrixData | null = null;

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.fetchMatrices();
  }

  fetchMatrices() {
    this.http.get<any[]>('http://localhost:8080/matrices').subscribe(
      (response) => {
        console.log("Se reciben matrices y nombres");
        this.matrices = response.map(item => ({
          matrix: item.matrix,
          name: item.name
        }));

        for (const matrix of this.matrices) {
          this.updateMatrix(matrix.name, matrix.matrix);
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }

  updateMatrix(name: string, matrix: string[][]) {
    const existingMatrix = this.matrices.find((m) => m.name === name);

    if (existingMatrix) {
      console.log("Se actualiza matriz");
      existingMatrix.matrix = matrix;
    } else {
      console.log("Se añade matriz");
      this.matrices.push({ name, matrix });
    }

    // Asignar la respuesta del backend a la variable responseMatrix
    this.responseMatrix = { name, matrix };
  }

  sendInstructions() {
    const instructions = this.instructionText;
    this.http.post<any>('http://localhost:8080/your-endpoint', { instructions }).subscribe(
      (response) => {
        console.log("Respuesta del backend:", response);
        this.updateMatrix(response.name, response.matrix);
      },
      (error) => {
        console.error(error);
      }
    );
  }
  sendInstructions2() {
    const instructions = this.instructionText;
    this.http.post<any>('http://localhost:8080/commit', { instructions }).subscribe(
      (response) => {
        console.log("Respuesta del backend:", response);
        this.updateMatrix(response.name, response.matrix);
      },
      (error) => {
        console.error(error);
      }
    );
  }
}
