package lector;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import java.io.File;
import java.io.IOException;

public class DOMDelComments {

	public static void main(String[] args ) {
		
		try {
			String filepath = "/Users/Santi/Desktop/Proyectos/DOMeje/main/resources/propiedades_original.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the root element
			Node propiedades = doc.getElementsByTagName("propiedades").item(0);
			


			// loop the staff child node
			NodeList list = propiedades.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {

	                   Node node = list.item(i);

			   // Borrando Comentarios
			   if ("#comment".equals(node.getNodeName())) {
				   propiedades.removeChild(node);
				   System.out.println("PIOLA");
			   }


			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("/Users/Santi/Desktop/Proyectos/DOMeje/main/resources/propiedades_modificado.xml"));
			transformer.transform(source, result);

			System.out.println("Done");

		   } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		   } catch (TransformerException tfe) {
			tfe.printStackTrace();
		   } catch (IOException ioe) {
			ioe.printStackTrace();
		   } catch (SAXException sae) {
			sae.printStackTrace();
		   }
		}
}
