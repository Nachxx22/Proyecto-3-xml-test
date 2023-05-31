import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class XMLCreate {
    public static void XMLcrear(String[][] matriz, String NombreArchivo) {
        try {
            //String NombreArchivo="testeo";
            // Crea un objeto DocumentBuilderFactory
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Crea un objeto Document vacío
            Document doc = docBuilder.newDocument();

            // Crea el elemento raíz del XML
            Element rootElement = doc.createElement("Root");
            doc.appendChild(rootElement);

            // Crea instancias con atributos
            /*
            crearInstanciaConAtributos(doc, rootElement, "Instancia1", "Atributo1", "Valor1");
            crearInstanciaConAtributos(doc, rootElement, "Instancia2", "Atributo2", "Valor2");
            crearInstanciaConAtributos(doc, rootElement, "Instancia3", "Atributo3", "Valor3");
            */
             for (int i=0;i<=4;i++){
                 for (int j=0;j<=4;j++){
                     System.out.println("entrada");
                     System.out.println(matriz[i][0]);
                     if(i==4) {
                         System.out.println("entrada al if");
                         System.out.println(matriz[i][0]);
                         crearInstanciaConAtributos(doc,rootElement,matriz[0][0],matriz[i][0],matriz[i][0]);
                     }else{
                         System.out.println("entrada al else");
                         System.out.println(matriz[i + 1][0]);
                         crearInstanciaConAtributos(doc,rootElement,matriz[0][0],matriz[i][0],matriz[i+1][0]);
                     }
                     //crearInstanciaConAtributos(doc,rootElement,matriz[0][0],matriz[i][0],matriz[i+1][0]);
                 }
             }

            // Crea un objeto Transformer para escribir el contenido del Document en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Especifica la ruta y el nombre del archivo XML que deseas crear
            String rutaProyecto = System.getProperty("user.dir");
            String nombreArchivo=NombreArchivo;
            CrearCarpeta.crearCarpeta(NombreArchivo);
            String rutaArchivo = rutaProyecto + "/src/"+ NombreArchivo+"/"+ NombreArchivo+".xml";
            File archivo = new File(rutaArchivo);

            // Crea el archivo XML
            Result result = new StreamResult(archivo);
            Source source = new DOMSource(doc);
            transformer.transform(source, result);

            System.out.println("El archivo XML se ha creado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void crearInstanciaConAtributos(Document doc, Element parentElement, String instancia, String atributo, String valor) {
        // Crea el elemento de la instancia
        System.out.println("Crearinstanciaconatributos");
        System.out.println(instancia);
        Element instanciaElement = doc.createElement(instancia);
        parentElement.appendChild(instanciaElement);

        // Crea el atributo y lo asigna al elemento de la instancia
        instanciaElement.setAttribute(atributo, valor);
    }

}