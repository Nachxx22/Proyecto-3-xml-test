package com.example.mydatabasece_backend.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class MatrizController {

    /**
     * Endpoint para obtener las matrices.
     *
     * @return ResponseEntity con una lista de mapas que representan las matrices y sus nombres.
     */
    @GetMapping("/matrices")
    public ResponseEntity<List<Map<String, Object>>> getMatrices() {
        List<Map<String, Object>> matrices = new ArrayList<>();

        // Obtener matriz "Carros"
        String nombre = "Carros";
        String[][] matriz = XMLreader.readXML(nombre);
        String nombreMatriz = nombre;
        matrices.add(createMatrixResponse(matriz, nombreMatriz));

        // Obtener matriz "Clientes"
        String nombre2 = "Clientes";
        String[][] matriz2 = XMLreader.readXML(nombre2);
        String nombreMatriz2 = nombre2;
        matrices.add(createMatrixResponse(matriz2, nombreMatriz2));

        // Obtener matriz "DatosPedidos"
        String nombre3 = "DatosPedidos";
        String[][] matriz3 = XMLreader.readXML(nombre3);
        String nombreMatriz3 = nombre3;
        matrices.add(createMatrixResponse(matriz3, nombreMatriz3));

        // Obtener matriz "Estudiantes"
        String nombre4 = "Estudiantes";
        String[][] matriz4 = XMLreader.readXML(nombre4);
        String nombreMatriz4 = nombre4;
        matrices.add(createMatrixResponse(matriz4, nombreMatriz4));

        // Obtener matriz "NotaCursos"
        String nombre5 = "NotaCursos";
        String[][] matriz5 = XMLreader.readXML(nombre5);
        String nombreMatriz5 = nombre5;
        matrices.add(createMatrixResponse(matriz5, nombreMatriz5));

        // Obtener matriz "EstudiantesNotaCursos"
        String nombre6 = "EstudiantesNotaCursos";
        String[][] matriz6 = XMLreader.readXML(nombre6);
        String nombreMatriz6 = nombre6;
        if (XMLreader.readXML(nombre6).length == 0) {
            System.out.println("No existe");
        } else {
            matrices.add(createMatrixResponse(matriz6, nombreMatriz6));
        }

        // Obtener matriz "EstudiantesNotaCursos" (segunda vez)
        String nombre7 = "EstudiantesNotaCursos";
        String[][] matriz7 = XMLreader.readXML(nombre7);
        String nombreMatriz7 = nombre7;
        if (XMLreader.readXML(nombre7).length == 0) {
            System.out.println("No existe");
        } else {
            matrices.add(createMatrixResponse(matriz7, nombreMatriz7));
        }

        // Obtener matriz "ClientesDatosPedidos"
        String nombre8 = "ClientesDatosPedidos";
        String[][] matriz8 = XMLreader.readXML(nombre8);
        String nombreMatriz8 = nombre8;
        if (XMLreader.readXML(nombre8).length == 0) {
            System.out.println("No existe");
        } else {
            matrices.add(createMatrixResponse(matriz8, nombreMatriz8));
        }

        // Obtener matriz "ClientesCarros"
        String nombre9 = "ClientesCarros";
        String[][] matriz9 = XMLreader.readXML(nombre9);
        String nombreMatriz9 = nombre9;
        if (XMLreader.readXML(nombre9).length == 0) {
            System.out.println("No existe");
        } else {
            matrices.add(createMatrixResponse(matriz9, nombreMatriz9));
        }

        // Obtener matriz "CarrosDatosPedidos"
        String nombre10 = "CarrosDatosPedidos";
        String[][] matriz10 = XMLreader.readXML(nombre10);
        String nombreMatriz10 = nombre10;
        if (XMLreader.readXML(nombre10).length == 0) {
            System.out.println("No existe");
        } else {
            matrices.add(createMatrixResponse(matriz10, nombreMatriz10));
        }

        return ResponseEntity.ok(matrices);
    }


    /**
     * Crea una respuesta de matriz que contiene la matriz y su nombre.
     *
     * @param matriz       La matriz representada como un arreglo bidimensional de cadenas.
     * @param nombreMatriz El nombre de la matriz.
     * @return Un mapa que contiene la matriz y su nombre.
     */
    private Map<String, Object> createMatrixResponse(String[][] matriz, String nombreMatriz) {
        Map<String, Object> matrixResponse = new HashMap<>();
        matrixResponse.put("matrix", matriz);
        matrixResponse.put("name", nombreMatriz);
        return matrixResponse;
    }
}
