import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class XMLreader {
    public static void main(String[] args) {
        String nombreArchivo = "Estudiantes";
        String rutaProyecto = System.getProperty("user.dir");
        String filePath = rutaProyecto + "/src/" + nombreArchivo + "/" + nombreArchivo + ".xml";
        readXML(filePath);
    }

    public static void readXML(String filePath) {
        try {
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList rows = document.getElementsByTagName("row");
            int numRows = rows.getLength();

            // Obtener los nombres de las columnas
            Element headerRow = (Element) rows.item(0);
            NodeList headers = headerRow.getChildNodes();
            int numCols = 0;

            // Contar el número de nombres de columnas válidos
            for (int j = 0; j < headers.getLength(); j++) {
                String columnName = headers.item(j).getNodeName().trim();
                if (!columnName.isEmpty() && !columnName.equals("#text")) {
                    numCols++;
                }
            }

            // Crear la matriz para almacenar los datos
            String[][] data = new String[numRows][numCols];

            int colIndex = 0; // Índice de columna

            // Agregar los nombres de las columnas a la primera fila de la matriz
            for (int j = 0; j < headers.getLength(); j++) {
                String columnName = headers.item(j).getNodeName().trim();
                if (!columnName.isEmpty() && !columnName.equals("#text")) {
                    data[0][colIndex] = columnName;
                    colIndex++;
                }
            }

            // Obtener los datos de las celdas y almacenarlos en la matriz
            for (int i = 1; i < numRows; i++) {
                Element row = (Element) rows.item(i);
                NodeList cells = row.getChildNodes();

                colIndex = 0; // Reiniciar el índice de columna

                for (int j = 0; j < cells.getLength(); j++) {
                    String cellData = cells.item(j).getTextContent().trim(); // Eliminar espacios en blanco
                    if (!cellData.isEmpty() && !cellData.equals("#text")) { // Evitar datos innecesarios
                        data[i][colIndex] = cellData;
                        colIndex++;
                    }
                }
            }

            // Imprimir la matriz de datos
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Error al leer el archivo XML: " + e.getMessage());
        }
    }
}