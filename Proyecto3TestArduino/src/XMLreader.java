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
        String NombreArchivo="Estudiantes";
        // Especifica la ruta y el nombre del archivo XML que deseas crear
        String rutaProyecto = System.getProperty("user.dir");
        String nombreArchivo=NombreArchivo;
        CrearCarpeta.crearCarpeta(NombreArchivo);
        String filePath = rutaProyecto + "/src/"+ NombreArchivo+"/"+ NombreArchivo+".xml";
        //String filePath = "ruta/del/archivo/datos.xml"; // Cambiar la ruta y el nombre del archivo según sea necesario
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
            Element headerRow = (Element) rows.item(0);
            NodeList headers = headerRow.getChildNodes();

            for (int i = 0; i < headers.getLength(); i++) {
                System.out.print(headers.item(i).getNodeName() + "\t\t");
            }
            System.out.println();

            for (int i = 1; i < rows.getLength(); i++) {
                Element row = (Element) rows.item(i);
                NodeList cells = row.getChildNodes();

                for (int j = 0; j < cells.getLength(); j++) {
                    System.out.print(cells.item(j).getTextContent() + "\t\t");
                }
                System.out.println();
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Error al leer el archivo XML: " + e.getMessage());
        }
    }
}
