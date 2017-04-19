import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Juan Lagostena on 04/09/16
 * jlagostena@bitsense.com.ar
 * .
 */
public class DOMRecorridaBasica {


    public static void main(String [] args) throws IOException, SAXException {

        // Creamos el parseador
        DOMParser parser = new DOMParser();

        ClassLoader classLoader = DOMRecorridaBasica.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("propiedades_original.xml");
        // Procesamos el fichero XML
        parser.parse(new InputSource(inputStream));
        Document doc = parser.getDocument();

        Element root = doc.getDocumentElement();
        // Iteramos sobre sus children
        NodeList children = root.getChildNodes();

        for(int i=0;i<children.getLength();i++){
            Node node = children.item(i);
            System.out.println(node.getNodeName());
        }

    }

}
