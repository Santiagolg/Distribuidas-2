package explorer;

import com.sun.xml.internal.ws.util.xml.NodeListIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Created by Juan Lagostena on 04/09/16
 * jlagostena@bitsense.com.ar
 * .
 */
public class DOMExplorer {

    private Element root;

    public DOMExplorer(Document document) {
        this.root = document.getDocumentElement();
    }

    public void traversePreOrder() {
        traversePreOrder(this.root);
    }

    private void traversePreOrder(Node root) {
        processNode(root, new PrinterNodeProcessor());
        NodeListIterator nodeListIterator = new NodeListIterator(root.getChildNodes());
        while (nodeListIterator.hasNext()) {
            traversePreOrder((Node)nodeListIterator.next());
        }

    }

    private void processNode(Node node, NodeProcessor task) {
        task.processNode(node);
    }
}
