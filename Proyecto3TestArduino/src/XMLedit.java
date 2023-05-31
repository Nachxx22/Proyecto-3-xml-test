import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XMLedit {
    public static void main(String[] args) {
        String[][] Datos = {
                {"ID", "Nombre", "Edad", "Carrera", "Curso"},
                {"3322", "Carlos", "24", "Computadores", "Datos"},
                {"1024", "Felipe", "20", "Industrial", "Calculo"},
                {"3052", "Juan", "22", "Electronica", "Fisica"},
                {"2060", "Jose", "25", "Computadores", "Calculo"}
        };

        String NombreArchivo="Estudiantes";
        // Especifica la ruta y el nombre del archivo XML que deseas crear
        String rutaProyecto = System.getProperty("user.dir");
        String nombreArchivo=NombreArchivo;
        CrearCarpeta.crearCarpeta(NombreArchivo);
        String filePath = rutaProyecto + "/src/"+ NombreArchivo+"/"+ NombreArchivo+".xml";
        // Ejemplo de edición de un elemento específico
        //editElement(Datos, 2, 4, "NuevoCurso", filePath);

        // Ejemplo de edición de varios elementos con nuevos datos
        //Map<Integer, Integer> updates = new HashMap<>();
        //updates.put(2, 1); // Fila 2, columna 1
        //updates.put(3, 3); // Fila 3, columna 3
        editElement(Datos, "Curso", "Datos", "Calculo", filePath);
    }

    public static void editElement(String[][] data, String columnName, String currentValue, String newValue, String filePath) {
        int columnIndex = -1;
        String[] headers = data[0];

        // Buscar el índice de la columna basado en el nombre
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equals(columnName)) {
                columnIndex = i;
                break;
            }
        }

        if (columnIndex == -1) {
            System.out.println("La columna especificada no existe.");
            return;
        }

        // Buscar el elemento en la columna y realizar el cambio
        for (int i = 1; i < data.length; i++) {
            if (data[i][columnIndex].equals(currentValue)) {
                data[i][columnIndex] = newValue;
            }
        }

       XMLWriter.writeXML(data, filePath);
    }

}
